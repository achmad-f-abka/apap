package com.apap.tu03.service;
import java.util.List;

import java.util.ArrayList;

import org.springframework.stereotype.Service;


@Service
public class InMemoryMovieService implements MovieService{
	private List<MovieModel> archiveMovie;
	public InMemoryMovieServie() {
		archiveMovie = new ArrayList<>();
	}
	
	public void addMovie(MovieModel movie) {
		archiveMovie.add(movie);
	}
	
	public List<MovieModel> getMovieList(){
		return archiveMovie;
	}

}
