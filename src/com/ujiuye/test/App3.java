package com.ujiuye.test;

import com.ujiuye.pojo.Husband;
import com.ujiuye.pojo.Order;
import com.ujiuye.pojo.Person;
import com.ujiuye.pojo.Wife;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Set;

/**
 * 一对多
 */
public class App3 {




    @Test
    public void testGet(){
        //默认去resources/src下找名字为hibernate.cfg.xml的配置文件
        Configuration configuration=new Configuration().configure();
        //创建SqlSessionFactory  session工厂
        SessionFactory factory = configuration.buildSessionFactory();
        //创建session
        Session session = factory.openSession();
        //查用户  看对应的订单
        Person person=(Person)session.get(Person.class,2);
        Set<Order> orders = person.getOrders();
        System.out.println(person);
        for (Order order:orders){
            System.out.println(order);
        }
        System.out.println("=====================================");
//        //查订单   看对应的用户
        Order order=(Order)session.get(Order.class,3);
        Person person1 = order.getPerson();
        System.out.println(order);
        System.out.println(person1);

        //关闭session
        session.close();


    }



}
