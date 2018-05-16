package com.faydan.guopf.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Menu {
    private Integer id;

    private String name;

    private String icon;

    private String url;

    private String permission;

    private String level;

    private Integer sort;

    private String isMenu;

    private String status;

    private String isOpen;

    private Set<User> users = new HashSet<>();

}