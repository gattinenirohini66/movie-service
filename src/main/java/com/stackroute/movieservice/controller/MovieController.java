package com.stackroute.movieservice.controller;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.addMovie(movie), HttpStatus.OK);
    }
    @GetMapping("/movies")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
    }
    @GetMapping("/movie/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable int id){
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id),HttpStatus.OK);
    }
    @DeleteMapping("/movie/{id}")
    public void deleteById(@PathVariable int id){
        movieService.delById(id);
    }
    @PutMapping("/movie/{id}")
    public ResponseEntity<Object> update(@RequestBody Movie user,@PathVariable int id){
        return new ResponseEntity<Object>(movieService.update(user,id),HttpStatus.OK);
    }
}
