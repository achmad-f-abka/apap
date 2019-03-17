package com.apap.tu03.controller;

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
public class MovieController {
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
	
//	@RequestMapping("/movie/view")
//	public String view(@RequestParam(value = "id") String id, Model model) {
//		MovieModel archive = movieService.getMovieDetail(id);
//		model.addAttribute("movie", archive);
//		return "movie-view";
//	}
	
	@RequestMapping("/movie/viewall")
	public String viewAll(Model model) {
		List<MovieModel> archive = movieService.getMovieList();
		model.addAttribute("movies", archive);
		return "viewall-movie";
	}
	
	@RequestMapping(value={"/movie/view","/movie/view/{id}"})
	public String viewMovie(@PathVariable Optional<String> id, Model model) {
		if (id.isPresent()) {
			for (MovieModel mov : movieService.getMovieList()) {
				if (mov.getId().equals(id.get())) {
					model.addAttribute("movie", mov);
					return "movie-view";
				}
			}
			return "view-notfound";
			
		} else {
			return "view-notfound";
		}
	}
	
	@RequestMapping(value= {"/movie/update","/movie/update//duration/{duration}"
							,"/movie/update/{id}/duration/{duration}"})
	public String updateDuration(@PathVariable Optional<String> id, 
								 @PathVariable Optional<Integer> duration, 
								 Model model) {
		if (id.isPresent() && !duration.equals(null)) {
			for (MovieModel mov : movieService.getMovieList()) {
				if (mov.getId().equals(id.get())) {
					movieService.updateDuration(id.get(), duration.get());
					System.out.println(mov.getDuration());
					model.addAttribute("movie", mov);
					return "update-duration";
				}
			}
			return "update-failed";
			
		} else{
			return "update-failed";
		}
	}
	
	@RequestMapping(value= {"/movie/delete","/movie/delete/{id}"})
	public String delete(@PathVariable Optional<String> id, Model model) {
		if (id.isPresent()) {
			for (MovieModel mov : movieService.getMovieList()) {
				if (mov.getId().equals(id.get())) {
					movieService.deleteMovie(mov);
					return "delete";
				}
			}
			return "delete-failed";
		}else {
			return "delete-failed";
		}
	}
	
	
}
