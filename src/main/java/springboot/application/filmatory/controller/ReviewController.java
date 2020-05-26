package springboot.application.filmatory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import springboot.application.filmatory.dao.UserDao;
import springboot.application.filmatory.model.Movie;
import springboot.application.filmatory.model.Review;
import springboot.application.filmatory.model.User;
import springboot.application.filmatory.service.MovieService;
import springboot.application.filmatory.service.ReviewService;
import springboot.application.filmatory.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private ReviewService reviewService;
    private UserService userService;

    @Autowired
    public ReviewController(ReviewService reviewService, UserService userService) {
        this.reviewService = reviewService;
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Review> getReviews() {
        return reviewService.getReviews();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Review getReview(@PathVariable Integer id) {
        return reviewService.getReview(id);
    }
    
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Review updateReview(@RequestBody Review review) {
        return reviewService.updateReview(review);
    }

    @DeleteMapping(value= "/{id}")
    public boolean deleteReview(@PathVariable Integer id) {
        return reviewService.deleteReview(id);
    }

    @PostMapping(value = "/user/{userId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Review createReview(@PathVariable Integer userId, @RequestBody Review review) {
        User user = userService.find(userId);
        user.addReview(review);
//        if (user != null) {
//            review.setUser(user);
//            return reviewService.createReview(review);
//        }
        return null;
    }
}
