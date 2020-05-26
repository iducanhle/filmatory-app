package springboot.application.filmatory.dao;

import org.springframework.stereotype.Repository;
import springboot.application.filmatory.model.Movie;
import springboot.application.filmatory.model.Product;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MovieDao extends BaseDao<Movie> {

    public MovieDao() {
        super(Movie.class);
    }

    public List<Movie> findByName(String name) {
        TypedQuery<Movie> query = em.createQuery("select e from Movie e where e.name=:name", Movie.class);
        return query.setParameter("name", name).getResultList();
    }

    public List<Movie> findByRuntime(int runtime) {
        TypedQuery<Movie> query = em.createQuery("select e from Movie e where e.runtime=:runtime", Movie.class);
        return query.setParameter("runtime", runtime).getResultList();
    }
}
