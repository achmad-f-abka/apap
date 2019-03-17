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
	public void updateMovie(String id, Integer newDuration) {
		for(int j=0; j<archiveMovie.size();j++) {
			if(archiveMovie.get(j).getId().equals(id)) {
				archiveMovie.get(j).setDuration(newDuration);
				archiveMovie.set(j,archiveMovie.get(j));
			}
		}
	}
	
	@Override
	public void deleteMovie(MovieModel movie) {
		archiveMovie.remove(movie);
	}

	@Override
	public List<MovieModel> getMovieList() {
		return archiveMovie;
	}

	@Override
	public MovieModel getMovieDetail(String id) {
		
		for (MovieModel mm : archiveMovie) {
			if (mm.getId().equalsIgnoreCase(id)) {
				return mm;
			}
		}
		return null;
	}
	
	
}
