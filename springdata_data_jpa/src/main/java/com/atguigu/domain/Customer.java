package com.atguigu.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 所有的注解都是使用JPA的规范提供的注解，
 所以在导入注解包的时候，一定要导入javax.persistence下的

 映射：实体类和数据库表
 * @Entity:放置到类的上面，表示该类就是一个持久化对象，与数据库表建立的映射
 * @Table(name = "cst_customer")：放置到类的上面，表示该实体类对应表的名称叫做cst_customer
 *     如果不写name="cst_customer"，此时类的名称就是表的名称
 *
 *  映射：实体类的属性和数据库表的字段
 *  映射ID
 *     @Id：映射主键ID的字段
 *     @GeneratedValue(strategy = GenerationType.IDENTITY)：id是自增长
 *  映射普通字段
 *     @Column(name = "cust_id")：放置到属性上，用来表示映射数据库列的名称
 *        如果不写cust_id：映射的列叫做custId（满足命名的规则，也可以映射cust_id）

 @Entity
 作用：指定当前类是实体类。
 @Table
 作用：指定实体类和表之间的对应关系。
 属性：
 name：指定数据库表的名称
 @Id
 作用：指定当前字段是主键。
 @GeneratedValue
 作用：指定主键的生成方式。。
 属性：
 strategy ：指定主键生成策略。
 @Column
 作用：指定实体类属性和数据库表之间的对应关系
 属性：
 name：指定数据库表的列名称。
 unique：是否唯一
 nullable：是否可以为空
 inserttable：是否可以插入
 updateable：是否可以更新
 columnDefinition: 定义建表时创建此列的DDL
  *  主键的生成策略：
  *    IDENTITY:主键由数据库自动生成（主要是自动增长型）  -- Mysql
  *    SEQUENCE：根据底层数据库的序列来生成主键，条件是数据库支持序列。 -- Oracle
 */

@Entity //声明实体类
@Table(name="cst_customer") //建立实体类和表的映射关系
public class Customer {

    @Id//声明当前私有属性为主键
    @GeneratedValue(strategy=GenerationType.IDENTITY) //配置主键的生成策略
    @Column(name="cust_id") //指定和表中cust_id字段的映射关系
    private Long custId;

    @Column(name="cust_name") //指定和表中cust_name字段的映射关系
    private String custName;

    @Column(name="cust_source")//指定和表中cust_source字段的映射关系
    private String custSource;

    @Column(name="cust_industry")//指定和表中cust_industry字段的映射关系
    private String custIndustry;

    @Column(name="cust_level")//指定和表中cust_level字段的映射关系
    private String custLevel;

    @Column(name="cust_address")//指定和表中cust_address字段的映射关系
    private String custAddress;

    @Column(name="cust_phone")//指定和表中cust_phone字段的映射关系
    private String custPhone;

    //  生成set get 和tostring方法

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }
}

