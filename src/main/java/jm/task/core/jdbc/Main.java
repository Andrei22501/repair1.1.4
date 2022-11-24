package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
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
