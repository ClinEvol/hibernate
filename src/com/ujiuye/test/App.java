package com.ujiuye.test;

import com.ujiuye.pojo.Dog;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 基本的CURD
 */
public class App {

    @Test
    public void testSave(){
        //默认去resources/src下找名字为hibernate.cfg.xml的配置文件
        Configuration configuration=new Configuration().configure();
        //创建SqlSessionFactory  session工厂
        SessionFactory factory = configuration.buildSessionFactory();
        //创建session
        Session session = factory.openSession();
        //如果是增删改的话，需要手动开始事务
        Transaction transaction = session.beginTransaction();
        //创建狗对象
        Dog dog=new Dog(0,"五狐狸","123456",new Date());
        //添加一个狗对象   把狗添加到数据库中
        session.save(dog);
        //提交事务
        transaction.commit();
        //关闭session
        session.close();
        System.out.println("添加成功");

    }

    //修改   通过主键id修改
    @Test
    public void testUpdate(){
        //默认去resources/src下找名字为hibernate.cfg.xml的配置文件
        Configuration configuration=new Configuration().configure();
        //创建SqlSessionFactory  session工厂
        SessionFactory factory = configuration.buildSessionFactory();
        //创建session
        Session session = factory.openSession();
        //如果是增删改的话，需要手动开始事务
        Transaction transaction = session.beginTransaction();
        //创建狗对象
        Dog dog=new Dog(2,"二狗","665544",new Date());
        //添加一个狗对象   把狗添加到数据库中
        session.update(dog);
        //提交事务
        transaction.commit();
        //关闭session
        session.close();
        System.out.println("修改成功");
    }

    //删除   通过主键id进行删除
    @Test
    public void testDelete(){
        //默认去resources/src下找名字为hibernate.cfg.xml的配置文件
        Configuration configuration=new Configuration().configure();
        //创建SqlSessionFactory  session工厂
        SessionFactory factory = configuration.buildSessionFactory();
        //创建session
        Session session = factory.openSession();
        //如果是增删改的话，需要手动开始事务
        Transaction transaction = session.beginTransaction();
        //创建狗对象
        Dog dog=new Dog(2,"二狗","665544",new Date());
        //添加一个狗对象
        session.delete(dog);
        //提交事务
        transaction.commit();
        //关闭session
        session.close();
        System.out.println("删除成功");
    }

    //
    @Test
    public void testGet(){
        //默认去resources/src下找名字为hibernate.cfg.xml的配置文件
        Configuration configuration=new Configuration().configure();
        //创建SqlSessionFactory  session工厂
        SessionFactory factory = configuration.buildSessionFactory();
        //创建session
        Session session = factory.openSession();
        //如果是增删改的话，需要手动开始事务
        //Transaction transaction = session.beginTransaction();

        //添加一个狗对象
        Dog dog=(Dog)session.get(Dog.class,1);
        //提交事务
        //transaction.commit();
        //关闭session
        session.close();
        System.out.println(dog);
    }

    //查列表
    @Test
    public void testList(){
        //默认去resources/src下找名字为hibernate.cfg.xml的配置文件
        Configuration configuration=new Configuration().configure();
        //创建SqlSessionFactory  session工厂
        SessionFactory factory = configuration.buildSessionFactory();
        //创建session
        Session session = factory.openSession();

        //hql 注意from Dog中的Dog是实体类的名字，不是表名
        Query query = session.createQuery("from Dog");
        List<Dog> list = query.list();
        for (Dog dog:list){
            System.out.println(dog);
        }
        //关闭session
        session.close();

    }

}
