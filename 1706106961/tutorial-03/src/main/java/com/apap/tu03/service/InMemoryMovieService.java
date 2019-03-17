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
		// TODO Auto-generated method stub
		return archiveMovie;
	}

	@Override
	public MovieModel getMovieDetail(String id) {
		MovieModel detailMovie= null;
        for(MovieModel detailMovies: archiveMovie){
            if(detailMovies.getId().equalsIgnoreCase(id))
                detailMovie=detailMovies;
        }
        return detailMovie;
	}
	
	@Override
	public MovieModel deleteMovie(String id) {
		MovieModel movie= getMovieDetail(id);
		if(movie !=null) 
			archiveMovie.remove(movie);
		return movie;
		
	}
	
}
