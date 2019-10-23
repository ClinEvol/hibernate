package com.ujiuye.pojo;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Person  implements Serializable {
    private int Id;
    private String Name;
    private Date Bir;
    private String Address;
    private int age;

    private Set<Order> orders;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getBir() {
        return Bir;
    }

    public void setBir(Date bir) {
        Bir = bir;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Bir=" + Bir +
                ", Address='" + Address + '\'' +
                ", age=" + age +
                '}';
    }
}
