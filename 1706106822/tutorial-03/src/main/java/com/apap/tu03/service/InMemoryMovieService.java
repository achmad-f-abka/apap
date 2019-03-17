package com.apap.tu03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tu03.model.Movie;

@Service
public class InMemoryMovieService implements MovieService{
	private List<Movie> archiveMovie;

	public InMemoryMovieService() {
		// TODO Auto-generated constructor stub
		archiveMovie = new ArrayList<>();
	}
	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		archiveMovie.add(movie);
	}

	@Override
	public List<Movie> getMovieList() {
		// TODO Auto-generated method stub
		return archiveMovie;
	}

	@Override
	public Movie getMovieDetail(String id) {
		// TODO Auto-generated method stub
		for(int i=0;i<archiveMovie.size();i++) {
			if (archiveMovie.get(i).getId().equals(id)) {
				return archiveMovie.get(i);
			}
		}
		return null;
	}


}
