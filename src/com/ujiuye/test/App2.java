package com.ujiuye.test;

import com.ujiuye.pojo.Dog;
import com.ujiuye.pojo.Husband;
import com.ujiuye.pojo.Wife;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * 一对一
 */
public class App2 {

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
        Husband husband=new Husband(0,"梁山伯");
        Wife wife=new Wife(0,"祝英台");
        //添加一个狗对象   把狗添加到数据库中
        session.save(husband);
        session.save(wife);
        //提交事务
        transaction.commit();
        //关闭session
        session.close();
        System.out.println("添加成功");

    }


    @Test
    public void testGet(){
        //默认去resources/src下找名字为hibernate.cfg.xml的配置文件
        Configuration configuration=new Configuration().configure();
        //创建SqlSessionFactory  session工厂
        SessionFactory factory = configuration.buildSessionFactory();
        //创建session
        Session session = factory.openSession();

        //查老公 看对应的老婆对不对
        Husband husband=(Husband)session.get(Husband.class,1);
        Wife wife=husband.getWife();
        System.out.println(husband);
        System.out.println(wife);

        //查老婆看对应的老公
        Wife wife2=(Wife)session.get(Wife.class,4);
        Husband husband2=wife2.getHusband();
        System.out.println(wife2);
        System.out.println(husband2);

        //关闭session
        session.close();


    }



}
