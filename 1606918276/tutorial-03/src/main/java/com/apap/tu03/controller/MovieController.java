package com.apap.tu03.controller;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.	web.bind.annotation.RequestParam;

import com.apap.tu03.model.MovieModel;
import com.apap.tu03.service.MovieService;

@Controller
public class MovieController {
	@Autowired 
	private MovieService movieService;
	
	@RequestMapping("/movie/add")
	public String add(@RequestParam(value="id", required = true) String id,
			@RequestParam(value="title", required = true)String title,
			@RequestParam(value="genre", required = true)String genre,
			@RequestParam(value="budget", required = true)Long budget,
			@RequestParam(value="duration", required = true)Integer duration) {
		MovieModel movie = new MovieModel(id, title, genre, budget, duration);
		movieService.addMovie(movie);
		return "add";
	}
	
	@RequestMapping("/movie/view")
	public String view(@RequestParam(value = "id") String id, Model model) {
		MovieModel archive = movieService.getMovieDetail(id);
		model.addAttribute("movie", archive);
		return "view-movie";
	}
	
	@RequestMapping("/movie/viewall")
	public String viewAll(Model model) {
		List<MovieModel> archive = movieService.getMovieList();
		model.addAttribute("movies", archive);
		return "viewall-movie";
	}
	
	@RequestMapping("/movie/view/{id}")
	public String viewMovie(@PathVariable Optional<String> id, Model model) {
		if(id.isPresent()) {
			for(MovieModel movie: movieService.getMovieList()) {
				if(movie.getId().equals(id.get())) {
					MovieModel archive = movieService.getMovieDetail(id.get());
					model.addAttribute("movie", archive);
					return "view-movie";
				}
				else {
					return "error";
				}
			}
		}
		else if (!id.isPresent()) {
			return "error";
		}
		return null;
	}
	
	@RequestMapping("/movie/update/{id}/duration/{duration}")
	public String updateDurationMovie(@PathVariable Optional<String> id, @PathVariable Optional<Integer> duration, Model model) {
		
		if(id.isPresent()) {
			for(MovieModel movie: movieService.getMovieList()) {
				
				if(movie.getId().equals(id.get())) {
					String titleOfMovie = movieService.getMovieDetail(id.get()).getTitle();
					int durationOfMovie = movieService.getMovieDetail(id.get()).getDuration();
					movieService.getMovieDetail(id.get()).setDuration(duration.get());
					int newDuration = duration.get();
					model.addAttribute("title", titleOfMovie);
					model.addAttribute("durationOfMovie", durationOfMovie);
					model.addAttribute("newDuration", newDuration);
					return "edit-duration";
				}
				else {
					return "error";
				}
			}
		}
		else if (!id.isPresent()) {
			return "error";
		}
		return null;
	}
	
	@RequestMapping("/movie/delete/{id}")
	public String deleteOfMovie(@PathVariable Optional<String> id, Model model) {
		if(id.isPresent()) {
			
			for(MovieModel movie: movieService.getMovieList()) {
				if(movie.getId().equals(id.get())) {
					for (Iterator<MovieModel> listOfMovie = movieService.getMovieList().listIterator(); listOfMovie.hasNext(); ) {
					    MovieModel a = listOfMovie.next();
					    if (a.getId().equalsIgnoreCase(id.get())) {
					        listOfMovie.remove();
					    }
					}
					model.addAttribute("id", id.get());
					return "delete";
				}
				else {
					return "error";
				}
			}
		}
		else if (!id.isPresent()) {
			return "error";
		}
		return null;
	}

}
