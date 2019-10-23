package com.ujiuye.pojo;

import java.io.Serializable;

/*
 *老婆
 */
public class Wife implements Serializable {
    private int id;
    private String name;
    private Husband husband;

    public Wife(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Wife() {
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

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
