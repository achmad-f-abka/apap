package com.apap.tu03.controller;

import java.awt.List;
import java.util.Iterator;
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
	
	@RequestMapping ("/movie/add")
	public String add (@RequestParam (value = "id", required = true) String id,
			@RequestParam (value = "title", required = true) String title,
			@RequestParam (value = "genre", required = true) String genre,
			@RequestParam (value = "budget", required = true) Long budget,
			@RequestParam (value = "duration", required = true) Integer duration) {
		MovieModel movie = new MovieModel (id, title, genre, budget, duration);
		movieService.addMovie(movie);
		return "add";
	}
	
	@RequestMapping("/movie/view")
	public String view (@RequestParam("id") String id, Model model) {
		MovieModel archive = movieService.getMovieDetail(id);
		model.addAttribute("movie", archive);
		return "view-movie";
	}
	
	@RequestMapping("/movie/viewall")
	public String viewall(Model model) {
		List archive =(List) movieService.getMovieList();
		model.addAttribute("movie", archive);
		return "viewall-movie";
	}
	
	@RequestMapping("/movie/update/{id}/duration/{duration}")
	public String updateDuration(@PathVariable Optional<String> id, @PathVariable Optional<Integer> duration, Model model) {
		if (id.isPresent()) {
			for(MovieModel movie : movieService.getMovieList()) {
				if(movie.getId().equals(id.get())) {
					String movieTitle = movieService.getMovieDetail(id.get()).getTitle();
					int movieDuration = movieService.getMovieDetail(id.get()).getDuration();
					movieService.getMovieDetail(id.get()).setDuration(duration.get());
					int newDuration = duration.get();
					model.addAttribute("movieTitle", movieTitle);
					model.addAttribute("movieDuration", movieDuration);
					model.addAttribute("newDuration", newDuration);
					return "updateDuration";
				}
				else {
					return "errorHandling";
				}
			}
			return "error";
		}
		else if (!id.isPresent()) {
			return "errorHandling";
		}
		return null;
	}
	@RequestMapping("/movie/delete/{id}")
	public String deleteMovie(@PathVariable Optional<String> id, Model model) {
		if(id.isPresent()) {
			for(MovieModel movie : movieService.getMovieList()) {
				if(movie.getId().equals(id.get())) {
					for(Iterator<MovieModel> iterator = movieService.getMovieList().listIterator();
							iterator.hasNext();) {
						MovieModel m = iterator.next();
						if(m.getId().equalsIgnoreCase(id.get())) {
							iterator.remove();
						}
					}
					model.addAttribute("id", id.get());
					return "deleteMovie";
				}
				else {
					return "errorHandling";
				}
			}
			return "error";
		}
		else if(!id.isPresent()) {
			return "errorHandling";
		}
		return null;
	}
	
	

}
