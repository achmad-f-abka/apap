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
	
	@RequestMapping(value = {"/movie/view/{id}","/movie/view/"})
	public String viewPathById(@PathVariable Optional<String> id, Model model)
	{
				if(id.isPresent()) {
					MovieModel archive = movieService.getMovieDetail(id.get());
					if (archive==null) {
						model.addAttribute("output", "Id Not Found");
						return "output";
					}
					else {
						model.addAttribute("movie", archive);
						return "view-movie";
					}
				} else {
					model.addAttribute("output", "No Input ID");
						return "output";
				}
				
				
	}
	
	@RequestMapping(value = {"/movie/update","/movie/update/{id}/duration/{jumlah}"})
	public String update(@PathVariable Optional<String> id, @PathVariable Optional<String> jumlah, Model model) {
		if (id.isPresent()) {
			MovieModel modelMovie = movieService.getMovieDetail(id.get());
			if(modelMovie == null) {
				String expectation = "ID Not Found, Failed to Update";		
				model.addAttribute("output", expectation);
				return "output";
			} else {
				String expectation = "Berhasil";
				modelMovie.setDuration(Integer.parseInt(jumlah.get()));
				model.addAttribute("movies", modelMovie);
				return "viewall-movie";
			}
			
		}
		return "output";
	}
	

	@RequestMapping("/movie/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		
		if (movieService.getMovieDetail(id) == null) {
			String expectation = "ID Not Found, Failed to Delete";		
			model.addAttribute("output", expectation);
			return "output";
		} 
		movieService.deleteMovieDetail(id);
		return "delete";
		
	}
}