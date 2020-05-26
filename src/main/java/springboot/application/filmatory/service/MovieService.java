package springboot.application.filmatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.application.filmatory.dao.MovieDao;
import springboot.application.filmatory.model.Movie;

import java.util.List;

@Service
public class MovieService {
    private MovieDao movieDao;

    @Autowired
    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Transactional
    public Movie createMovie(Movie movie) {
        if (movie == null) {
            return null;
        }
        else {
            movieDao.persist(movie);
            return movie;
        }
    }

    @Transactional
    public Movie updateMovie(Movie movie) {
        return movieDao.update(movie);
    }

    @Transactional
    public boolean deleteMovie(Integer id) {
        Movie movie = movieDao.find(id);
        if (movie == null) {
            return false;
        }
        else {
            movieDao.remove(movie);
            return true;
        }
    }

    @Transactional
    public Movie getMovie(Integer id) {
        return movieDao.find(id);
    }

    @Transactional
    public List<Movie> getMovies() {
        return movieDao.findAll();
    }
}
