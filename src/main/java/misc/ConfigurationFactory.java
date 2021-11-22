package misc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//Factory for creating a session
public class ConfigurationFactory {

    private static Session session;

    private ConfigurationFactory(){}

    public static Session getSession(){
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        session = factory.openSession();
        return session;
    }
}
