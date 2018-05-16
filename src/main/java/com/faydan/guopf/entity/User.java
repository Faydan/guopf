package com.faydan.guopf.entity;

import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class User {
    private Integer id;

    private String avatar;

    private String username;

    private String password;

    private String salt;

    private String name;

    private Date birthday;

    private String sex;

    private String email;

    private String phone;

    private Integer deptId;

    private String status;

    private Date createTime;

    private Date updateTime;

    private Set<Role> roles = new HashSet<>();

}