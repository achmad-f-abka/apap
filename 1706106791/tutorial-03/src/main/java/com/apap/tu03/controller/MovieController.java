package com.apap.tu03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu03.model.MovieModel;
import com.apap.tu03.service.MovieService;

@Controller
public class MovieController {
	private MovieService movieService;
	
	@RequestMapping("/movie/add")
	public String add(@RequestParam(value ="id", required = true) String id,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "genre", required = true) String genre,
			@RequestParam(value = "budget", required = true) Long budget,
			@RequestParam(value = "duration", required = true) Integer duration){
		MovieModel movie = new MovieModel (id, title, genre, budget, duration);
		movieService.addMovie(movie);
		return "add";
	}
			

}
