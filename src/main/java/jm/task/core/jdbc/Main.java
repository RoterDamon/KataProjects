package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection = Util.getConnection();
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
        userDaoJDBC.saveUser("Kate", "Denisova", (byte) 21);
        userDaoJDBC.saveUser("George", "Zaic", (byte) 20);
        userDaoJDBC.saveUser("Nastia", "Johnson", (byte) 30);
        userDaoJDBC.saveUser("Nastia", "Williams", (byte) 28);
        userDaoJDBC.getAllUsers();
        userDaoJDBC.removeUserById(1);
        userDaoJDBC.cleanUsersTable();
        userDaoJDBC.dropUsersTable();

        SessionFactory sessionFactory = Util.getSessionFactory();
        UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.saveUser("Kate", "Denisova", (byte) 21);

        List<User> users = userDaoHibernate.getAllUsers();
        users.forEach(s -> System.out.println(s));
    }
}
