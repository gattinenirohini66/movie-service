package com.stackroute.movieservice.controller;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exception.MovieAlreadyExistsException;
import com.stackroute.movieservice.exception.MovieNotFoundException;
import com.stackroute.movieservice.service.MovieService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@Api(value="movieDatabase", description="Operations Pertaining to Movies")
public class MovieController {
    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movie")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie)throws MovieAlreadyExistsException {
       return new ResponseEntity<Movie>(movieService.addMovie(movie),HttpStatus.CREATED);
    }
    @GetMapping("/movies")
    public ResponseEntity<?> getAllMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(),HttpStatus.OK);
    }
    @GetMapping("/movie/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable int id){
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(id),HttpStatus.OK);
    }
    @GetMapping("/movies/{name}")
    public ResponseEntity<List<Movie>> findByName(@PathVariable String name) throws MovieNotFoundException {
        return new ResponseEntity<List<Movie>>(movieService.findByName(name),HttpStatus.CREATED);
    }
    @DeleteMapping("/movie/{id}")
    public ResponseEntity deleteById(@PathVariable int id){
        movieService.delById(id);
        return new ResponseEntity("Deleted sucessfully",HttpStatus.OK);
    }
    @PutMapping("/movie/{id}")
    public ResponseEntity<Object> update(@RequestBody Movie user,@PathVariable int id){
        return new ResponseEntity<Object>(movieService.update(user,id),HttpStatus.OK);
    }
}
