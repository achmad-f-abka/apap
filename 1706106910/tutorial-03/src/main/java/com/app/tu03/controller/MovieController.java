package com.app.tu03.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.tu03.model.MovieModel;
import com.app.tu03.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	private long budget;
	private Integer duration;
	boolean isEqual;
	private MovieModel moviem = new MovieModel("", "", "", budget, duration);

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
	public String view1(@RequestParam("id") String id, Model model) {
		MovieModel archive = movieService.getMovieDetail(id);
		model.addAttribute("movie", archive);
		return "view-movie";
	}

	@RequestMapping(value = { "/movie/delete/", "movie/delete/{id}" })
	public String delete(@PathVariable Optional<String> id, Model model) {
		List<MovieModel> archivelist = movieService.getMovieList();

		if (id.isPresent()) {
			for (int i = 0; i < archivelist.size(); i++) {
				moviem = archivelist.get(i);
				isEqual = id.equals(Optional.of(moviem.getId()));
			}				
				if (isEqual) {
					archivelist.remove(moviem);
					MovieModel archiveMo = movieService.getMovieDetail(id);
					model.addAttribute("movie", moviem);
					model.addAttribute("successDelete", true);
				} else {
					model.addAttribute("failDelete", true);
					model.addAttribute("movie", moviem);
				}
			
		} else {
			model.addAttribute("failDelete", true);
			model.addAttribute("movie", moviem);
		}

		return "view-movie";
	}

	@RequestMapping(value = { "/movie/view/", "/movie/view/{id}" })
	public String view(@PathVariable Optional<String> id, Model model) {
		List<MovieModel> archivelist = movieService.getMovieList();

		if (id.isPresent()) {
			for (int i = 0; i < archivelist.size(); i++) {
				MovieModel mv = archivelist.get(i);
				boolean isEqual = id.equals(Optional.of(mv.getId()));
				if (isEqual) {
					MovieModel archiveMo = movieService.getMovieDetail(id);
					model.addAttribute("movie", archiveMo);
				} else {
					model.addAttribute("errorPage", true);
					model.addAttribute("movie", moviem);
				}
			}
		} else {
			model.addAttribute("errorPage", true);
			model.addAttribute("movie", moviem);
		}
		model.addAttribute("errorPage", true);
		model.addAttribute("movie", moviem);
		return "view-movie";
	}
	
	@RequestMapping(value = { "/movie/update/", "/movie/update/{id}/duration/{duration}", "/movie/update/{id}"})
	public String update(@PathVariable Optional<String> id, @PathVariable Optional <Integer> duration, Model model) {
		List<MovieModel> archivelist = movieService.getMovieList();
		if (id.isPresent()) {
			for (int i = 0; i < archivelist.size(); i++) {
				MovieModel mv = archivelist.get(i);
				boolean isEqual = id.equals(Optional.of(mv.getId()));
				if (isEqual) {
					mv.setDuration(duration.get());
					MovieModel archiveMo = movieService.getMovieDetail(id);
					model.addAttribute("movie", archiveMo);
					model.addAttribute("successUpdate", true);
				} else {
					model.addAttribute("failUpdate", true);
					model.addAttribute("movie", moviem);
				}
			}
		} else {
			model.addAttribute("failUpdate", true);
			model.addAttribute("movie", moviem);
		}
		return "view-movie";
	}

	@RequestMapping("/movie/viewall")
	public String viewAll(Model model) {
		List<MovieModel> archive = movieService.getMovieList();
		model.addAttribute("movies", archive);
		return "viewall-movie";
	}
}
