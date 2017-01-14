package cn.happy.test;

import cn.happy.entity.House;
import cn.happy.entity.Users;
import cn.happy.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by cgg on 2017/1/12.
 */
public class MyTest {
    Transaction tran;
    @Before
    public void myBefore(){
        tran= HibernateUtil.currentSession().beginTransaction();
    }
    @After
    public void myAfter(){
        //tran.commit();
    }

    /**
     * 查询所有用户
     */
    @Test
    public void getAll(){
        String hql="from Users";
        Query query=HibernateUtil.currentSession().createQuery(hql);
        List<Users> list = query.list();
        for (Users item:list) {
            System.out.println(item.getName());
        }
        HibernateUtil.closeSession();
    }
    /**
     * 查询中关村地区面积大于80的房屋信息
     */
    @Test
    public  void houseTest(){
        String hql="from House where title like ? and floorage>?";
        Query query = HibernateUtil.currentSession().createQuery(hql);
        query.setParameter(0,"%双%");
        query.setParameter(1,80);
        List<House> list = query.list();
        for (House item:list) {
            System.out.println(item.getPrice());
        }
        HibernateUtil.closeSession();
    }
    /**
     * 动态参数绑定查询
     * 1.租金小于2000
     * 2.联系人是微冷的雨
     * 3.发布日期为近一个月
     */
    @Test
    public void test(){
        House house=new House();
        house.setPrice(80);
        house.setContact("微冷的雨");
        String hql="select new House(price,contact) from House where 1=1";
        StringBuffer sb=new StringBuffer(hql);
        if (house.getPrice()!=null){
            sb.append(" and price=:price ");
        }
        if (house.getContact()!=null){
            sb.append(" and contact=:contact");
        }

        Query query = HibernateUtil.currentSession().createQuery(sb.toString());
        query.setProperties(house);
        List<House> list = (List<House>)query.list();
        for (House item:list
             ) {
            System.out.println(item.getContact());
        }
        HibernateUtil.closeSession();
    }
}