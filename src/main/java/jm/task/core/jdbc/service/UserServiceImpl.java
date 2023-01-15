package jm.task.core.jdbc.service;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.util.List;

public class UserServiceImpl implements UserService {
//    UserDao userDaoHiber = new UserDaoHibernateImpl();
    UserDao userDao = new UserDaoJDBCImpl();
    public void createUsersTable() {
    userDao.createUsersTable();
//    userDaoHiber.createUsersTable();
    }

    public void dropUsersTable() {
    userDao.dropUsersTable();
//    userDaoHiber.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
    userDao.saveUser(name,lastName,age);
//    userDaoHiber.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
    userDao.removeUserById(id);
//    userDaoHiber.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
//        return userDaoHiber.getAllUsers();
    }

    public void cleanUsersTable() {
    userDao.cleanUsersTable();
//    userDaoHiber.cleanUsersTable();
    }
}
