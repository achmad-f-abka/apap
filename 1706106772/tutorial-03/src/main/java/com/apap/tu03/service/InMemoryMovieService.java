package com.apap.tu03.service;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import com.apap.tu03.model.MovieModel;

@Service
public class InMemoryMovieService implements MovieService {

	private List<MovieModel> archiveMovie;
	private String id;
	private String title;
	private String genre;
	private long budget;
	private Optional<Integer> duration;
	private MovieModel obj = new MovieModel(id, title, genre,budget,duration);
	
	public InMemoryMovieService() {
		archiveMovie= new ArrayList<>();
	}
	@Override
	public void addMovie(MovieModel movie) {
		// TODO Auto-generated method stub
		archiveMovie.add(movie);
	}

	@Override
	public List<MovieModel> getMovieList() {
		// TODO Auto-generated method stub
		return archiveMovie;
	}

	public List<MovieModel> getArchiveMovie() {
		return archiveMovie;
	}
	public void setArchiveMovie(List<MovieModel> archiveMovie) {
		this.archiveMovie = archiveMovie;
	}
	@Override
	public MovieModel getMovieDetail(String id) {
		    Iterator<MovieModel> iterator = archiveMovie.iterator();
		    while (iterator.hasNext()) {
		    	MovieModel movieModel = iterator.next();
		        if (movieModel.getId().equals(id)) {
		            return movieModel;		            
		        }
		    }
    return obj;
	}
	@Override	
	public MovieModel getMovieDetail(Optional<String> id) {
		Iterator<MovieModel> iterator = archiveMovie.iterator();
	    while (iterator.hasNext()) {
	    	MovieModel movieModel = iterator.next();
	    	boolean isEqual =id.equals(Optional.of(movieModel.getId()));
	        if (isEqual) {
	            return movieModel;		            
	        }
	    }
	return obj;
	}

}
