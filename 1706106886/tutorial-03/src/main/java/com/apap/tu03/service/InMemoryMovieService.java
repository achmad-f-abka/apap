package com.apap.tu03.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.apap.tu03.model.MovieModel;

@Service
public class InMemoryMovieService implements MovieService{
	private List<MovieModel> archieveMovie;
	private String id, title, genre;
	private long budget;
	private Integer duration;
	private MovieModel mm = new MovieModel(id, title, genre, budget, duration);
	
	public InMemoryMovieService() {
		archieveMovie = new ArrayList<>();
	}
	
	@Override
	public void addMovie(MovieModel movie) {
		archieveMovie.add(movie);
	}

	@Override
	public List<MovieModel> getMovieList() {
		return archieveMovie;
	}

	@Override
	public MovieModel getMovieDetail(String id) {
		Integer id1 = Integer.parseInt(id) - 1;
		return archieveMovie.get(id1);
//		Iterator<MovieModel> iterator = archieveMovie.iterator();
//	    while (iterator.hasNext()) {
//	    	MovieModel mvmodel = iterator.next();
//	        if (id.equals(Optional.of(mvmodel.getId()))) {
//	            return mvmodel;		            
//	        }
//	    }
//	    return mm;
	}

	@Override
	public MovieModel getMovieDetail(Optional<String> id) {
		//Integer id1 = Optional.of(mv.getId()))
		Iterator<MovieModel> iterator = archieveMovie.iterator();
	    while (iterator.hasNext()) {
	    	MovieModel mvmodel = iterator.next();
	        if (id.equals(Optional.of(mvmodel.getId()))) {
	            return mvmodel;		            
	        }
	    }
	    return mm;
	}

}
