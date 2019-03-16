package com.apap.tu03.controller;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu03.model.MovieModel;
import com.apap.tu03.service.MovieService;

@Controller
public class 	MovieController {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movie/add")
	public String add(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "genre", required = true) String genre,
			@RequestParam(value = "budget", required = true) Long budget,
			@RequestParam(value = "duration", required = true) Integer duration) {
		
		MovieModel movie = new MovieModel(id, title, genre, budget, duration);
		movieService.addMovie(movie);
		return "add";	
	}
	@RequestMapping("/movie/view")
	public String view(@RequestParam("id")String id, Model model) {
		MovieModel archieve = movieService.getMovieDetail(id);
		model.addAttribute("movie", archieve);
		return "view-movie"; 
	} 
	@RequestMapping("/movie/viewall")
	public String viewAll(Model model) {
		List<MovieModel> archieve = movieService.getMovieList();
		model.addAttribute("movies", archieve);
		return "viewall-movie";
	}
	@RequestMapping("/movie/view/{id}")
	public String viewId(@PathVariable Optional <String> id, Model model ) {
		if (id.isPresent()){
			for (int i = 0; i< movieService.getMovieList().size() ;) {
				if(movieService.getMovieList().get(i).getId().equalsIgnoreCase(id.get())){
					MovieModel archieve = movieService.getMovieDetail(id.get());
					model.addAttribute("movie", archieve);
					return "view-movie";
				}
				else {
					return "error";
				}
			}
		}
		return null;
	}

	@RequestMapping("/movie/update/{id}/duration/{duration}")
	public String update (@PathVariable Optional<String> id, @PathVariable Optional <Integer> duration, Model model) {
		if(id.isPresent() && duration.isPresent()) { //ada apa engga id  sm duration kalo ada lanjut
			for(int i = 0 ; i< movieService.getMovieList().size(); i++){ // loop isi db
				if(movieService.getMovieList().get(i).getId().equals(id.get())) { //sama ga
					int oldduration = movieService.getMovieList().get(i).getDuration();
					movieService.getMovieDetail(id.get()).setDuration(duration.get()); //set
					model.addAttribute("oldDuration", oldduration);
					model.addAttribute("newDuration", duration.get());
					return "duration";
				}
				else {
					return "error";
				}
			}
		}
		return null;
	}
	@RequestMapping("/movie/delete/{id}")
	public String delete(@PathVariable Optional <String> id, Model model) {
		if(id.isPresent()) {
			for(int i = 0; i< movieService.getMovieList().size() ; i++) {
				if(movieService.getMovieList().get(i).getId().equals(id.get())) {
					movieService.getMovieList().remove(i);
				}
			else {
				return "error";
			}
				model.addAttribute("id", id.get());
				return "delete";
			}
			
		} 
	return null;
	} 
}