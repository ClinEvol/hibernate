package com.ujiuye.pojo;

/*
 *老公
 */
public class Husband {
    private int id;
    private String name;
    private Wife wife;

    public Husband(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Husband() {
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

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
