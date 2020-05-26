package springboot.application.filmatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.application.filmatory.dao.MovieDao;
import springboot.application.filmatory.dao.ReviewDao;
import springboot.application.filmatory.model.Movie;
import springboot.application.filmatory.model.Review;

import java.util.List;

@Service
public class ReviewService {
    private ReviewDao reviewDao;

    @Autowired
    public ReviewService(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Transactional
    public Review createReview(Review review) {
        if (review == null) {
            return null;
        }
        else {
            reviewDao.persist(review);
            return review;
        }
    }

    @Transactional
    public Review updateReview(Review review) {
        return reviewDao.update(review);
    }

    @Transactional
    public boolean deleteReview(Integer id) {
        Review review = reviewDao.find(id);
        if (review == null) {
            return false;
        }
        else {
            reviewDao.remove(review);
            return true;
        }
    }

    @Transactional
    public Review getReview(Integer id) {
        return reviewDao.find(id);
    }

    @Transactional
    public List<Review> getReviews() {
        return reviewDao.findAll();
    }
}
