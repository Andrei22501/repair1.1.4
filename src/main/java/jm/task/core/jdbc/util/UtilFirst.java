package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilFirst {
        private static Connection connection;
        private static final String connectionUrl = "jdbc:mysql://localhost:3306/newbase";
        private static final String userName = "root";
        private static final String password = "root";
        public static Connection getConnection() {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(connectionUrl, userName, password);
                System.out.println("Соединение установлено");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("Ошибка соединения");
            }
            return connection;
        }
        public static void closeConnection() {
            try  {
                if (connection !=null) {
                    connection.close();

                    System.out.println("Соединение закрыто!!!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

