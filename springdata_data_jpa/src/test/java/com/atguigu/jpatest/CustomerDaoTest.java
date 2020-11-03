package com.atguigu.jpatest;

import com.atguigu.dao.CustomerDao;
import com.atguigu.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 根据id查询
     */
    @Test
    public void testFindOne() {
        Customer customer = customerDao.findOne(2l);
        System.out.println(customer);
    }

    /**
     * 插入数据
     */
    @Test
    public void save(){

        Customer customer = new Customer();
        customer.setCustAddress("杭州");
        customer.setCustIndustry("123");
        customer.setCustLevel("abab");
        customer.setCustName("易兵");
        customer.setCustSource("AK");

        customerDao.save(customer);

    }

    /**
     * 按照ID更新
     */
    @Test
    public void update(){

        // new对象，指定id更新
        Customer c = new Customer();
        c.setCustId(4l);
        c.setCustName("谷粒学院");
        c.setCustSource("互联网");
        c.setCustIndustry("IT教育培训");
        c.setCustLevel("VIP客户");
        c.setCustPhone("0755-22222222");
        c.setCustAddress("硅谷西部大厦");
        customerDao.save(c);

    }

    /**
     * 按照ID来删除一行
     */
    @Test
    public void delete(){
        customerDao.delete(4l);
    }

    /**
     * 查询所有
     */
    @Test
    public void findAll(){


        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }

    }

    /**
     * 查询所有（排序）
     Sort.Direction.AES：升序
     Sort.Direction.DESC：降序
     */
    @Test
    public void findAllSort(){
        Sort sort = new Sort(Sort.Direction.DESC,"custId");
        List<Customer> list = customerDao.findAll(sort);
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * 查询所有（分页+排序）
     */
    @Test
    public void findAllPageSort(){
//        Sort sort = new Sort(Sort.Direction.DESC,"custId");
        /**
         * PageRequest(int page, int size)
         * page：表示当前页，0表示基准页，0表示第1页
         * size：表示当前页最多显示的记录数
         */
        Pageable pageable = new PageRequest(0,4);
        Page<Customer> pageData = customerDao.findAll(pageable);
        System.out.println("总记录数："+pageData.getTotalElements());
        System.out.println("总页数："+pageData.getTotalPages());
        for (Customer customer : pageData.getContent()) {
            System.out.println(customer);
        }
    }

    /**
     * 测试统计查询：查询客户的总数量
     *      count:统计总条数
     */
    @Test
    public void testCount() {
        long count = customerDao.count();//查询全部的客户数量
        System.out.println("表中所有记录数为:"+count);
    }

    /**
     * 测试：判断id为4的客户是否存在
     *      1. 可以查询以下id为4的客户
     *          如果值为空，代表不存在，如果不为空，代表存在
     *      2. 判断数据库中id为4的客户的数量
     *          如果数量为0，代表不存在，如果大于0，代表存在
     *
     *          //延迟加载
     */
    @Test
    @Transactional
    public void  testExists() {
//        boolean exists = customerDao.exists(4l);
//        System.out.println("id为4的客户 是否存在："+exists);

        Customer one = customerDao.getOne(4l);//延迟加载  在使用到的时候才加载
//        customerDao.findOne()   立即加载
        System.out.println(one);
    }

    /**
     * 根据id从数据库查询
     *      @Transactional : 保证getOne正常运行
     *
     *  findOne：
     *      em.find()           :立即加载
     *  getOne：
     *      em.getReference     :延迟加载
     *      * 返回的是一个客户的动态代理对象
     *      * 什么时候用，什么时候查询
     */
    @Test
    @Transactional
    public void  testGetOne() {
        Customer customer = customerDao.getOne(4l);
        System.out.println(customer);
    }

    /**
     * 自定义查询所有sql
     */
    @Test
    public void t1(){
        List<Customer> allCustomers = customerDao.findAllCustomers();
        for (Customer allCustomer : allCustomers) {
            System.out.println(allCustomer);
        }
    }

    /**
     * 自定义模糊查询
     */
    @Test
    public void t2(){
        List<Customer> allByCustName = customerDao.findAllBycustName("%飞%");
        for (Customer customer : allByCustName) {

            System.out.println(customer);
        }
    }

    /**
     * 按照名字和地址进行模糊查询
     */
    @Test
    public void t3(){
        List<Customer> res = customerDao.findAllByCustNameAndCustAddress("%州%","%飞%");
        for (Customer re : res) {
            System.out.println(re);
        }
    }

}