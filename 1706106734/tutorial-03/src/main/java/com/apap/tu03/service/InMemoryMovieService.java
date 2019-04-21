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
	public MovieModel getMovieDetail(String id) {
		for(int i=0;i<archiveMovie.size();i++) {
			if(archiveMovie.get(i).getId().equals(id)) {
				return archiveMovie.get(i);
				
			}
		}
		return null;
	} 
	
	@Override
	public void addMovie(MovieModel movie) {
		archiveMovie.add(movie);
	}
	
	@Override
	public List<MovieModel> getMovieList(){
		return archiveMovie;
	}
	@Override
	public void updateMovie(String id, Integer newDuration) {
		for(int i=0;i<archiveMovie.size();i++) {
			if(archiveMovie.get(i).getId().equals(id)) {
				archiveMovie.get(i).setDuration(newDuration);
//				System.out.println(archiveMovie.get(i).getDuration());
				archiveMovie.set(i,archiveMovie.get(i));
			}
		}
	}
	@Override
	public void deleteMovie(MovieModel movie) {
		archiveMovie.remove(movie);
	}
}
