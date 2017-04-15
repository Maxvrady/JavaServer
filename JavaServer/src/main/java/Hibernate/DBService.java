package Hibernate;

import Hibernate.UserDataSet;
import org.hibernate.cfg.Configuration;

public interface DBService {

    Configuration getConf();

    void addUser(UserDataSet user);

    UserDataSet getUserById(Integer id);

    UserDataSet getUserByUsername(String username);

}
