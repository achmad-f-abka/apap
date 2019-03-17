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
	private String id, title, genre;
	private long budget;
	private Optional<Integer> duration;
	private MovieModel mm = new MovieModel(id, title, genre, budget, duration);

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
	public String view1(@RequestParam("id") String id, Model model) {
		MovieModel archive = movieService.getMovieDetail(id);
		model.addAttribute("movie", archive);
		return "view-movie";
	}

	@RequestMapping(value = { "/movie/delete/", "movie/delete/{id}" })
	public String delete(@PathVariable Optional<String> id, Model model) {
		List<MovieModel> archiveL = movieService.getMovieList();

		if (id.isPresent()) {
			for (MovieModel mobj : archiveL) {
				boolean isEqual = id.equals(Optional.of(mobj.getId()));
				if (isEqual) {
					while (archiveL.contains(Optional.of(mobj.getId()))) {
						System.out.println("OYAAA");
						archiveL.remove(mobj);
					}
					model.addAttribute("movie", mm);
					model.addAttribute("successDelete", true);
				}

			}
		} else {
			model.addAttribute("failDelete", true);
			model.addAttribute("movie", mm);
		}

		return "view-movie";
	}

	@RequestMapping(value = { "/movie/view/", "/movie/view/{id}" })
	public String view(@PathVariable Optional<String> id, Model model) {
		List<MovieModel> archiveL = movieService.getMovieList();

		if (id.isPresent()) {
			for (int i = 0; i < archiveL.size(); i++) {
				MovieModel mv = archiveL.get(i);
				boolean isEqual = id.equals(Optional.of(mv.getId()));
				if (isEqual) {
					MovieModel archiveM = movieService.getMovieDetail(id);
					model.addAttribute("movie", archiveM);
				} else {
					model.addAttribute("errorPage", true);
					model.addAttribute("movie", mm);
				}
			}
		} else {
			model.addAttribute("errorPage", true);
			model.addAttribute("movie", mm);
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
