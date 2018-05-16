package com.faydan.guopf.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Role {
    private Integer id;

    private String name;

    private Integer parentId;

    private Set<Menu> menus = new HashSet<>();
}