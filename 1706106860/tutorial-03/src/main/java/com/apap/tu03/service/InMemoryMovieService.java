package com.apap.tu03.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.apap.tu03.model.*;

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
		// TODO Auto-generated method stub
		return archiveMovie;
	}

	@Override
	public MovieModel getMovieDetail(String id) {
		// TODO Auto-generated method stub
		for(MovieModel movie: archiveMovie) {
			if(movie.getId().equalsIgnoreCase(id)) {
				return movie;
			}
		}
		return null;
	}
	
	
}
