package com.stackroute.movieservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data // used to generate setters and getters
@NoArgsConstructor // used to generate default constructor
@AllArgsConstructor // used to generate argument constructor
public class Movie {
    @Id // making id as primary key
    /*
        @GeneratedValue(strategy = GenerationType.AUTO)
        used to generate id automatically
     */
    private int movieId;
    private String movieTitle;
    private String overview;
}
