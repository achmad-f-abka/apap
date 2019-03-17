package com.apap.tu03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tu03.model.MovieModel;

@Service
public class InMemoryMovieService implements MovieService{
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
		for (int i = 0; i <= archiveMovie.size()-1; i++) {
			if (archiveMovie.get(i).getId().equalsIgnoreCase(id)) {
				return archiveMovie.get(i);
			}
		}
		return null;
	}

}
