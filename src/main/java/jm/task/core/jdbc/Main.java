package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;

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
    }
}
