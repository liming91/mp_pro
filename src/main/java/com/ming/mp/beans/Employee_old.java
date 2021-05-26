/*
package com.ming.mp.beans;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

*/
/**
 *
 * JavaBean和数据库表的字段对应,定义avaBean中成员变量时所使用的类型使用引用类型
 * 因为每个基本类型都有个默认值：
 * int==0
 * Boolean==false
 *//*

//MP会默认使用实体类的类名去数据库中找对应的表
 //value：数据库表名、resultMap:xml中resultMap的id
@TableName(value = "tbl_employee")
public class Employee {

    //TableId value指定表中的主键列的列名、如果实体名与表的列名一致不用指定
    //type:指定主键策略
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;

    @TableField(value = "last_name")
    private String lastName;

    private String email;

    private Integer gender;

    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
*/
