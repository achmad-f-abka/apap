package com.apap.tu03.service;

import java.util.*;
import com.apap.tu03.model.*;

public interface MovieService {
	void addMovie (MovieModel movie);
	List <MovieModel> getMovieList();
	MovieModel getMovieDetail (String id);
}