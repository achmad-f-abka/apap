package com.apap.tu03.service;

import java.util.List;

import com.apap.tu03.model.Movie;

public interface MovieService {
void addMovie(Movie movie);
List<Movie> getMovieList();
Movie getMovieDetail(String id);
}
