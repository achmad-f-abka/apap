package com.apap.tu03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tu03.model.MovieModel;

@Service
public class InMemoryMovieService implements MovieService {
	private List<MovieModel> archiveMovie;
	
	public InMemoryMovieService() {
		archiveMovie = new ArrayList<>();
	}
	
	@Override
	public void addMovie(MovieModel movie) {
		archiveMovie.add(movie);
	}
	
	@Override
	public List<MovieModel> getMovieList() {
		return archiveMovie;
	}

	@Override
	public MovieModel getMovieDetail(String id) {
		// TODO Auto-generated method stub
		for (int p = 0; p < archiveMovie.size(); p++) {
			if (archiveMovie.get(p).getId().equalsIgnoreCase(id)) {
				return archiveMovie.get(p);
			}
		}
		return null;
	}
}
