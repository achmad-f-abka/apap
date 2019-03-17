package com.apap.tu03.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import com.apap.tu03.model.MovieModel;
import com.apap.tu03.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
		
	
	@RequestMapping("/movie/add")
	public String add(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "genre", required = true) String genre,
			@RequestParam(value = "budget", required = true) Long budget,
			@RequestParam(value = "duration", required = true) Integer duration
			){
		MovieModel movie = new MovieModel(id, title, genre, budget, duration);
		movieService.addMovie(movie);
		return "add";
	}

	/*@RequestMapping("/movie/view")
	public String view(@RequestParam("id") String id, Model model) {
		MovieModel archive = movieService.getMovieDetail(id);
		model.addAttribute("movie", archive);
		return "view-movie";
	}*/
	
	@RequestMapping(value= {"/movie/view", "/movie/view/{id}"})
	public String view2(@PathVariable Optional<String> id, Model model) {
		if (id.isPresent()) {
			MovieModel archive = movieService.getMovieDetail(id.get());
			if (archive != null) {
				model.addAttribute("movie", archive);
				return "view-movie";
			} else  {
				return "error";
			}
		} else {
			return "error-2";
		}
		
	}
	
	@RequestMapping("/movie/viewall")
	public String viewAll(Model model) {
		List<MovieModel> archive = movieService.getMovieList();
		model.addAttribute("movies", archive);
		return "viewall-movie";
	}
	
	@RequestMapping(value= {"/movie/delete", "/movie/delete/{id}"})
	public String delete(@PathVariable Optional<String> id, Model model) {
		if (id.isPresent()) {	
			MovieModel archive = movieService.getMovieDetail(id.get());
			if (archive != null) {
				model.addAttribute("movie", archive);
				movieService.removeMovie(archive);
				return "delete";
			} else  {
				return "error";
			}
		} else {
			return "error-2";
		}
		
	}
	
	
	@RequestMapping(value= {"/movie/update", "/movie/update/{id}", "/movie/update/{id}/{duration}"})
	public String update(@PathVariable Optional<String> id, @PathVariable Optional<Integer> duration, Model model) {
		if (duration.isPresent() && id.isPresent()) {
			MovieModel archive = movieService.getMovieDetail(id.get());
			if (archive != null) {
				model.addAttribute("movie", archive);
				movieService.updateMovie(archive, duration.get());
				return "updated";
			} else  {
				return "error";
			}
			
		}  else {
			return "error-3";
		}
	}
	
}
