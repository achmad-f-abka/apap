package com.apap.tu03.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.apap.tu03.model.MovieModel;
import com.apap.tu03.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	private String id, title, genre;
	private long budget;
	private Optional<Integer> duration;
	private MovieModel obj = new MovieModel(id, title, genre, budget, duration);

	@RequestMapping("/movie/add")
	public String add(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "genre", required = true) String genre,
			@RequestParam(value = "budget", required = true) Long budget,
			@RequestParam(value = "duration", required = true) Optional<Integer> duration) {
		MovieModel movie = new MovieModel(id, title, genre, budget, duration);
		movieService.addMovie(movie);
		return "add";
	}

	@RequestMapping("/movie/view")
	public String viewDetail(@RequestParam("id") String id, Model model) {
		MovieModel archive = movieService.getMovieDetail(id);
		model .addAttribute("movie",archive);
		return "view-movie";
	}
	
	@RequestMapping("/movie/viewall")
	public String viewAll(Model model) {
		List<MovieModel> archive = movieService.getMovieList();
		model.addAttribute("movies", archive);
		return "viewall-movie";
	}

	@RequestMapping(value = { "/movie/view/", "/movie/view/{id}" })
	public String viewMovie(@PathVariable Optional<String> id, Model model) {
		List<MovieModel> modelL = movieService.getMovieList();

		if (id.isPresent()) {
			for (int i = 0; i < modelL.size(); i++) {
				MovieModel movieModel = modelL.get(i);
				boolean isEqual = id.equals(Optional.of(movieModel.getId()));
				if (isEqual) {
					MovieModel mService = movieService.getMovieDetail(id);
					model.addAttribute("movie", mService);
				} else {
					model.addAttribute("error", true);
					model.addAttribute("movie", obj);
				}
			}
		} else {
			model.addAttribute("error", true);
			model.addAttribute("movie", obj);
		}

		return "view-movie";
	}

	@RequestMapping(value = { "/movie/delete/", "movie/delete/{id}" })
	public String delete(@PathVariable Optional<String> id, Model model) {
		List<MovieModel> modelL = movieService.getMovieList();

		if (id.isPresent()) {
			for (MovieModel mobj : modelL) {
				boolean isEqual = id.equals(Optional.of(mobj.getId()));
				if (isEqual) {
					while (modelL.contains(Optional.of(mobj.getId()))) {
						modelL.remove(mobj);
					}
					model.addAttribute("movie", obj);
					model.addAttribute("successDelete", true);
				}

			}
		} else {
			model.addAttribute("failDelete", true);
			model.addAttribute("movie", obj);
		}

		return "view-movie";
	}
	
}
