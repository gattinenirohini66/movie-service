package com.stackroute.movieservice.configuration;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/* Running Logic on Startup in Spring. Create seed data to pre-fill the database with movie information whenever the application starts.
    Use both approaches:
      Approach 1: ApplicationListener<ContextRefreshedEvent>
      Approach 2: CommandLineRunner (Find out how it differs from ApplicationRunner)

      *differences
        * By default applicationListener will executes first after commandLineRunner
        * applicationListener takes arguments as parameters where as CLR will take string args as parameters.
*/
@Component
public class CommandListener implements CommandLineRunner {
    private String name;
    private MovieRepository movieRepository;

    @Autowired
    public CommandListener(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("command line");
        movieRepository.save(new Movie(2, "mari", "movie-data-2"));
    }
}
