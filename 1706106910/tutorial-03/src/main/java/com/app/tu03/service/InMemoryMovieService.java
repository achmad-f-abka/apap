package com.app.tu03.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.tu03.model.MovieModel;

@Service
public class InMemoryMovieService implements MovieService {
	private List<MovieModel> archiveMovie;
	private String id, title, genre;
	private long budget;
	private Integer duration;
	private MovieModel moviem = new MovieModel(id, title, genre, budget, duration);
	
	public  InMemoryMovieService() {
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
		    Iterator<MovieModel> iterator = archiveMovie.iterator();
		    while (iterator.hasNext()) {
		    	MovieModel mv = iterator.next();
		        if (mv.getId().equals(id)) {
		            return mv;		            
		        }
		    }
    return moviem;
	}

	@Override
	public MovieModel getMovieDetail(Optional<String> id) {
		Iterator<MovieModel> iterator = archiveMovie.iterator();
	    while (iterator.hasNext()) {
	    	MovieModel mv = iterator.next();
	    	boolean isEqual =id.equals(Optional.of(mv.getId()));
	        if (isEqual) {
	            return mv;		            
	        }
	    }
	return moviem;
	}
}
