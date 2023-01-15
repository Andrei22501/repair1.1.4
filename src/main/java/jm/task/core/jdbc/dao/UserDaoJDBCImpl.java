package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.UtilFirst;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        UtilFirst util = new UtilFirst();
        String query = "CREATE TABLE `newbase`.`user` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NOT NULL,\n" +
                "  `lastName` VARCHAR(45) NOT NULL,\n" +
                "  `age` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`));";
        try (Statement statement = util.getConnection().createStatement();) {
            statement.executeUpdate(query);
            statement.close();
            if (!statement.isClosed()) {
                System.out.println("Соединение установлено");
            }
        } catch (SQLException e) {
        }
    }

    public void dropUsersTable() {
        UtilFirst util = new UtilFirst();
        String query = "DROP TABLE IF EXISTS user";
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        UtilFirst util = new UtilFirst();
        String query = "insert into user(name,lastName,age) values('" + name + "','" + lastName + "'," + age + ")";
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("User с именем – " + name + " добавлен в базу данных");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        UtilFirst util = new UtilFirst();
        String query = "DELETE FROM `USER` WHERE ID =" + id;
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        UtilFirst util = new UtilFirst();
        String query = "select * from user";
        List<User> list;
        list = new ArrayList<User>();
        try {
            PreparedStatement pS = util.getConnection().prepareStatement(query);
            ResultSet resultSet = pS.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                list.add(user);
            }
            pS.close();
            resultSet.close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void cleanUsersTable() {
        UtilFirst util = new UtilFirst();
        String query = "truncate table user";
        try {
            Statement statement = util.getConnection().createStatement();
            statement.executeUpdate(query);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
