package springboot.application.filmatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.application.filmatory.dao.UserDao;
import springboot.application.filmatory.model.Movie;
import springboot.application.filmatory.model.Review;
import springboot.application.filmatory.model.User;
import springboot.application.filmatory.model.type.Role;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public User createUser(User user) {
        if (user == null) {
            return null;
        }
        else {
            if (user.getRole() == null) {
                user.setRole(Role.ROLE_USER);
            }
            userDao.persist(user);
            return user;
        }
    }

    @Transactional
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Transactional
    public boolean deleteUser(Integer id) {
        User user = userDao.find(id);
        if (user == null) {
            return false;
        }
        else {
            userDao.remove(user);
            return true;
        }
    }

    @Transactional
    public User updateUser(User user) {
        if (user != null) {
            return userDao.update(user);
        }
        return null;
    }

    @Transactional
    public void removeUser(User user) {
        userDao.remove(user);
    }

    @Transactional
    public User find(int id) {
        return userDao.find(id);
    }

    @Transactional
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}

