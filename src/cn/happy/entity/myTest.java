package cn.happy.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by cgg on 2017/1/9.
 */
public class myTest {
    Configuration cfg;
    Session session;
    Transaction tran;
    @Before
    public void myBefore(){
        //读取并解析配置文件
        cfg=new Configuration().configure("hibernate.cfg.xml");
        //读取并解析映射信息，创建SessionFactory对象
        SessionFactory factory = cfg.buildSessionFactory();
        //打开session
        //使用的getCurrentSession()方法，会自动关闭session
        session = factory.getCurrentSession();
        //开始一个事务（增删改操作必须，查询操作可选）
        tran=session.beginTransaction();
    }
    @After
    public void myAfter(){
        //结束事务
        tran.commit();;
    }
    //添加
    @Test
    public void addTest(){
        Student stu=new Student();
        stu.setSage(18);
        stu.setSname("安哲安哲");
        session.save(stu);
    }
    @Test
    public void findTest(){
        Student stu = session.load(Student.class, 11);
        System.out.print(stu.getSname());
    }
    @Test
    public void upTest(){
        Student stu = session.load(Student.class, 11);
        stu.setSname("安哲大傻逼");
    }
    @Test
    public void delTest(){
        Student stu = session.load(Student.class, 12);
        session.delete(stu);
    }
    /**
     * saveOrUpdater和merge()
     *//*
    @Test
    public void hahaTest(){
        Student stu = session.load(Student.class, 10);
        stu.setSname("川哥哥aa");
        session.merge(stu);
    }*/
}
