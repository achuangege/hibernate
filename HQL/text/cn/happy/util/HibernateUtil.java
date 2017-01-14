package cn.happy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by cgg on 2017/1/12.
 */
public class HibernateUtil {
    private static final ThreadLocal local=new ThreadLocal();
   private static Configuration cfg;
    private static final SessionFactory factory;
    static {
        cfg=new Configuration().configure();
        factory=cfg.buildSessionFactory();
    }

    public static Session currentSession(){
        Session session=(Session) local.get();
        if (session==null){
            session=factory.openSession();
            local.set(session);
        }
        return session;
    }

    public static void closeSession(){
        Session session=(Session)local.get();
        local.set(null);
        session.close();
    }
}
