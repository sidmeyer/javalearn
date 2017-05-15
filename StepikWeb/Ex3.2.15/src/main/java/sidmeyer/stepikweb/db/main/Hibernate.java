package sidmeyer.stepikweb.db.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.SourceType;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by stas on 15.05.17.
 */
public class Hibernate {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        cfg.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/webserver");
        cfg.setProperty("hibernate.connection.username", "root");
        cfg.setProperty("hibernate.connection.password", "root");
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.hbm2dll.auto", "update");

        cfg.addAnnotatedClass(UserDataSet.class);

        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
        ssrb.applySettings(cfg.getProperties());
        ServiceRegistry serviceRegistry = ssrb.build();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        System.out.append(transaction.getLocalStatus().toString());

        session.close();
        sessionFactory.close();


    }


}
