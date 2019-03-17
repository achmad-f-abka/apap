package com.apap.tu03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apap.tu03.model.*;
import com.apap.tu03.service.*;

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
	
	@RequestMapping("/movie/view/{id}")    //menggunakan PathVariable
	public String viewMovie(@PathVariable String id, Model model) {
		MovieModel archive = movieService.getMovieDetail(id);
		if(!(archive.equals(null))) {
			model.addAttribute("movie", archive);
			return "view-movie";
		}
		else {
			return "ID tidak ditemukan ";
		}
	}
	
	@RequestMapping("/movie/update/{id}/duration/{duration}")    //menggunakan PathVariable
	public String viewMovie(@PathVariable String id, @PathVariable Integer duration, Model model) {
		MovieModel archive = movieService.getMovieDetail(id);
		if(!(archive.equals(null))) {
			movieService.updateMovie(id, duration);
			return "update-movie";
		}
		else {
			return "id tidak ditemukan dan proses update dibatalkan ";
		}
	}
	
	@RequestMapping("/movie/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		MovieModel archive = movieService.getMovieDetail(id);
		if(!(archive.equals(null))) {
			movieService.deleteMovie(archive);
			return "delete-movie";
		}
		else {
			return " id tidak ditemukan dan proses delete dibatalkan.";
		}
	}
}


