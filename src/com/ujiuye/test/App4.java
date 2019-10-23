package com.ujiuye.test;

import com.ujiuye.pojo.Course;
import com.ujiuye.pojo.Order;
import com.ujiuye.pojo.Person;
import com.ujiuye.pojo.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;

import java.util.Set;

/**
 * 多对对
 */
public class App4 {




    @Test
    public void testGet(){
        //默认去resources/src下找名字为hibernate.cfg.xml的配置文件
        Configuration configuration=new Configuration().configure();
        //创建SqlSessionFactory  session工厂
        SessionFactory factory = configuration.buildSessionFactory();
        //创建session
        Session session = factory.openSession();
        //查学生  看对应的课程
        Student student=(Student)session.get(Student.class,2);
        Set<Course> courses = student.getCourses();
        System.out.println(student);
        for (Course course:courses){
            System.out.println(course);
        }

        System.out.println("=====================================");
        //查课程看对应的学生
        Course course=(Course)session.get(Course.class,2);
        Set<Student> students = course.getStudents();
        System.out.println(course);
        for (Student student1:students){
            System.out.println(student1);
        }

        //关闭session
        session.close();


    }



}
