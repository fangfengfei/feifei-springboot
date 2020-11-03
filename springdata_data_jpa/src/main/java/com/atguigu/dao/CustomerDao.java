package com.atguigu.dao;

import com.atguigu.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
/**
 * 符合SpringDataJpa的dao层接口规范
 *      JpaRepository<操作的实体类类型，实体类中主键属性的类型>
 *          * 封装了基本CRUD操作
 *      JpaSpecificationExecutor<操作的实体类类型>
 *          * 封装了复杂查询（分页）
 */

public interface CustomerDao extends JpaRepository<Customer,Long>{

    @Query(value = "from Customer ")
    List<Customer> findAllCustomers();

    /**
     * JpaRepository<T, ID extends Serializable>
     *      参数一：T泛型，表示实体类
     *      参数二：实体中ID的数据类型（主键的数据类型）
     */
    @Query(value = "from Customer where custName like ?")
    List<Customer> findAllBycustName(String custName);

    // 按照客户名称模糊查询，同时按照客户所属行业匹配查询
    /**
     * 如果jpql语句中存在多个占位符?，那么方法的参数的顺序与问号顺序要匹配，如果不一致呢？
     * 如果不一致，使用?+数字的形式
     *   例如：
     *   ?1：表示第1个参数
     *   ?2：表示第2个参数
     *   ?3：表示第3个参数
     *
     */
    @Query(value = "from Customer where custName like ?2 or custAddress like ?1")
    List<Customer> findAllByCustNameAndCustAddress(String custAddress,String  custName);

    // 使用@Query完成更新,@Query默认表示查询，如果要执行增删改的操作，
    // 需要在@Query注解的下面添加：@Modifying
    /**
     * JPQL：update Customer set custAddress = "西部硅谷广场" where custId = 2
     */
    @Query(value = "update Customer set custAddress = ? where custId = ?")
    @Modifying
    void updateCustomerCustAddress(String custAddress,Long custId);

}
