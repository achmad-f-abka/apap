package com.apap.tu03.service;
import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tu03.model.MovieModel;




@Service
public class InMemoryMovieService implements MovieService {
	private List<MovieModel> archieveMovie;
	
	public InMemoryMovieService() {
		archieveMovie = new ArrayList<>();
	}
	
	@Override
	public void addMovie(MovieModel movie) {
		// TODO Auto-generated method stub
		archieveMovie.add(movie);
		
	}

	@Override
	public List<MovieModel> getMovieList() {
		// TODO Auto-generated method stub
		return archieveMovie;
	}

	@Override
	public MovieModel getMovieDetail(String id) {
		// TODO Auto-generated method stub
			for (int i = 0; i < archieveMovie.size(); i++) {
			if(archieveMovie.get(i).getId().equalsIgnoreCase(id)) {
				return archieveMovie.get(i);
			}
			}
			return null;
	}
	
}