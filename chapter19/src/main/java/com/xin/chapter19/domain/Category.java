package com.xin.chapter19.domain;

import java.io.Serializable;

/**
 * 书籍的类别
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 4716481624612946124L;

    private int id;

    /**
     * 类别的名称
     */
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
