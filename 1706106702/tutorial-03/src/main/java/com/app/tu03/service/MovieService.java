package com.app.tu03.service;

import java.util.List;
import java.util.Optional;

import com.app.tu03.model.MovieModel;

public interface MovieService {
	void addMovie(MovieModel movie);
	List<MovieModel> getMovieList();
	MovieModel getMovieDetail(Optional<String> id);
	MovieModel getMovieDetail(String id);
}