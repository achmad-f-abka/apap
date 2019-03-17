package com.apap.tu03.service;


import java.util.ArrayList;





import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tu03.model.MovieModel;




@Service
public class InMemoryMovieService implements MovieService {
	private List<MovieModel> archiveMovie;
	//private MovieModel movie;
	
	public InMemoryMovieService() {
		archiveMovie = new ArrayList<>();
	}
	
	@Override
	public void addMovie(MovieModel movie) {
		// TODO Auto-generated method stub
		//archiveMovie = new ArrayList <>();
		archiveMovie.add(movie);	
	}
	


	@Override
	public List<MovieModel> getMovieList() {
		//return null;
		return archiveMovie;
	}
	
	@Override
	public void updMovie(String id, Integer newDuration) {
		for(int i=0; i<archiveMovie.size();i++) {
			if(archiveMovie.get(i).getId().equals(id)) {
				archiveMovie.get(i).setDuration(newDuration);
				archiveMovie.set(i,archiveMovie.get(i));
			}
		}
	}
	
	@Override
	public MovieModel getMovieDetail(String id) {
		for (MovieModel m : archiveMovie) {
			if(m.getId().equalsIgnoreCase(id)) {
				return m;
		}
			}
		return null;
	}

	@Override
	public void delMovie(MovieModel movie) {
		// TODO Auto-generated method stub
		archiveMovie.remove(movie);
		
	}
}