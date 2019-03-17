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
	
	@Override
	public void addMovie(MovieModel movie) {
		archiveMovie.add(movie);
	}
	
	@Override
	public List<MovieModel> getMovieList(){
		return archiveMovie;
	}
	
	//getMovie berdasarkan ID
	public MovieModel getMovieDetail(String id) {
		MovieModel movieInfo = null;
		for (MovieModel m : archiveMovie ) {
			if(m.getId().equals(id)) {
				movieInfo = m;
			}
		}
		return movieInfo;
	}
	
	//fungsi update
	public void updateMovie (String id , String attr, String val) {
		for (MovieModel m : archiveMovie) {
			if(m.getId().equals(id)) {
				m.updateInfo(attr, val);
			}
		}
	}
	
	//fungsi hapus
	public void deleteMovie (String id) {
		for (MovieModel m : archiveMovie) {
			if(m.getId().equals(id)) {
				archiveMovie.remove(m);
				break;
			}
		}
	}
	

	
	
}
