package springboot.application.filmatory.dao;

import org.springframework.stereotype.Repository;
import springboot.application.filmatory.model.Movie;
import springboot.application.filmatory.model.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Repository
public class UserDao extends BaseDao<User> {
    public UserDao() {
        super(User.class);
    }

    public User findByEmail(String email) {
        Query query = em.createQuery("select e from User e where e.email=:email", User.class);
        return (User) query.setParameter("email", email).getSingleResult();
    }
}
