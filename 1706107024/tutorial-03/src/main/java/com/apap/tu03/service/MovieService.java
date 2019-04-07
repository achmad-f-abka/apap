package com.apap.tu03.service;

import java.util.List;

import com.apap.tu03.model.MovieModel;

public interface MovieService {
	void addMovie(MovieModel movie);
	void removeMovie(MovieModel movie);
	void updateMovie(MovieModel movie, int duration);
	List<MovieModel> getMovieList();
	MovieModel getMovieDetail(String id);
	
}
