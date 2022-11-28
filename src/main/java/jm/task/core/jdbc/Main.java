package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {


    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Andrei", "Solskii", (byte) 20);
        userService.saveUser("Ignat", "Izosimov", (byte) 19);
        userService.saveUser("Big", "Lebowskii", (byte) 53);
        userService.saveUser("Ryan", "Gosling", (byte) 43);
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
        userService.dropUsersTable();
    }
}

