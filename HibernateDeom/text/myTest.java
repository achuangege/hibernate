import cn.happy.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by cgg on 2017/1/12.
 */
public class myTest {
    Configuration cfg;
    Session session;
    Transaction tran;
    @Before
    public void myBefore(){
        //读取并解析配置文件
        cfg=new Configuration().configure();
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

    @Test
    public void getOrLoad(){
        //Student stu=new Student();
        Student stu=session.load(Student.class,5);
        System.out.print(stu);
    }
}
