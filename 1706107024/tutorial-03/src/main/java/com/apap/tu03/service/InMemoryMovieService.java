package com.apap.tu03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tu03.model.MovieModel;

@Service
public class InMemoryMovieService implements MovieService {
	private List<MovieModel> archiveMovie;
	
	public InMemoryMovieService() {
		archiveMovie = new ArrayList<>();
	}

	public void addMovie(MovieModel movie) {
		archiveMovie.add(movie);
	}
	

	public List<MovieModel> getMovieList() {
		return archiveMovie;
	}
	
	public void removeMovie(MovieModel movie) {
		archiveMovie.remove(movie);
	}
	
	public void updateMovie(MovieModel movie, int duration) {
		for(int i=0; i < archiveMovie.size(); i++)
        {
            if(archiveMovie.get(i).equals(movie)) {
            	archiveMovie.get(i).setDuration(duration);
            }
        }
	}
	
	public MovieModel getMovieDetail(String id) {
		MovieModel result = null;
		for (int i = 0; i< archiveMovie.size(); i++) {
			if (id.equals(archiveMovie.get(i).getId())) {
				result = archiveMovie.get(i);
			}else {
				result = null;
			}
		}
		return result;
	}

}
