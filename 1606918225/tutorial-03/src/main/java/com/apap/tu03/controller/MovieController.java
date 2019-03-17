package com.apap.tu03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.apap.tu03.model.MovieModel;
import com.apap.tu03.service.MovieService;
import java.util.List;
import java.util.Optional;
import java.util.Iterator;

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
	public String view(@RequestParam("id") String id, Model model) {
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
	public String viewMoviePath(@PathVariable Optional<String> id, Model model) {
		if(id.isPresent()) {
			for(MovieModel movie : movieService.getMovieList()) {
				if(movie.getId().equals(id.get())) {
					MovieModel archive = movieService.getMovieDetail(id.get());
					model.addAttribute("movie", archive);
					return "view-movie";
				}
<<<<<<< HEAD:1606917954/tutorial-03/src/main/java/com/apap/tu03/controller/MovieController.java
=======
				else {
					return "errorHandling";
				}
>>>>>>> 9f965cac8a534815bb61e4b20a02642f94f06359:1606918225/tutorial-03/src/main/java/com/apap/tu03/controller/MovieController.java
			}
			return "error";
		}
		else if(!id.isPresent()) {
			return "errorHandling";
		}
		return null;
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
<<<<<<< HEAD:1606917954/tutorial-03/src/main/java/com/apap/tu03/controller/MovieController.java
=======
				else {
					return "errorHandling";
				}
>>>>>>> 9f965cac8a534815bb61e4b20a02642f94f06359:1606918225/tutorial-03/src/main/java/com/apap/tu03/controller/MovieController.java
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
<<<<<<< HEAD:1606917954/tutorial-03/src/main/java/com/apap/tu03/controller/MovieController.java
=======
				else {
					return "errorHandling";
				}
>>>>>>> 9f965cac8a534815bb61e4b20a02642f94f06359:1606918225/tutorial-03/src/main/java/com/apap/tu03/controller/MovieController.java
			}
			return "error";
		}
		else if(!id.isPresent()) {
			return "errorHandling";
		}
		return null;
	}
}
