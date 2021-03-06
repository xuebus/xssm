package com.xuebusi.xssm.pojo;

import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * Created by 学布斯 on 2017/12/18.
 */
public class XUser implements Serializable{
    private Integer id;

    private String name;

    private String address;

    private Integer age;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotBlank(message="用户名不能为空")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @NotBlank(message="地址不能为空")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
}