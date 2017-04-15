package Hibernate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class DBServiceImpl implements DBService {

    private Configuration conn = getConf();
    private SessionFactory factory = conn.buildSessionFactory();

    public Configuration getConf() {

        Configuration configurations = new Configuration();
        configurations.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        configurations.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configurations.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/JavaDB");
        configurations.setProperty("hibernate.connection.username", "fedora");
        configurations.setProperty("hibernate.connection.password", "Fedora95!");
        configurations.setProperty("hibernate.connection.show_sql", "true");
        configurations.setProperty("hibernate.hbm2ddl.auto", "update");

        configurations.addAnnotatedClass(UserDataSet.class);
        return configurations;
    }

    public void addUser(UserDataSet user) {

        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public UserDataSet getUserById(Integer id) {

        Session session = factory.openSession();
        session.beginTransaction();
        return session.load(UserDataSet.class, id);
    }

    public UserDataSet getUserByUsername(String username) {

        Session session = factory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UserDataSet.class);
        return (UserDataSet) criteria.add(Restrictions.eq("username", username)).uniqueResult();
    }
}
