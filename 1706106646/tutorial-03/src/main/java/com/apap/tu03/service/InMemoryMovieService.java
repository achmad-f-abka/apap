package com.apap.tu03.service;

import java.util.ArrayList;
import java.util.List;

import com.apap.tu03.model.MovieModel;

import org.springframework.stereotype.Service;

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
        return archiveMovie;
    }

    // Method getMovieDetail Impl
    @Override
    public MovieModel getMovieDetail(String id) {
        MovieModel movie= null;
        for(MovieModel sync: archiveMovie){
            if(sync.getId().equalsIgnoreCase(id))
                movie=sync;
        }
        return movie;
    }

    // Method deleteMovie by Id
    @Override
    public MovieModel deleteMovie(String id) {
        MovieModel movie= getMovieDetail(id);
        if (movie != null)
            archiveMovie.remove(movie);
        return movie;
    }
}