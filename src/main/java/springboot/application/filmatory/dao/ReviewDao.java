package springboot.application.filmatory.dao;

import org.springframework.stereotype.Repository;
import springboot.application.filmatory.model.Movie;
import springboot.application.filmatory.model.Review;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ReviewDao extends BaseDao<Review> {

    public ReviewDao() {
        super(Review.class);
    }
}
