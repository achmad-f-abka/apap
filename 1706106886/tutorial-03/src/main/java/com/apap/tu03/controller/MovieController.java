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
	private String id, title, genre;
	private long budget;
	private Integer duration;
	private MovieModel movie = new MovieModel(id,title,genre,budget,duration);
	
	@RequestMapping("/movie/add")
	public String add(@RequestParam(value="id", required = true) String id,
			@RequestParam(value="title", required = true) String title,
			@RequestParam(value="genre", required = true) String genre,
			@RequestParam(value="budget", required = true) Long budget,
			@RequestParam(value="duration", required = true) Integer duration) {
		
		MovieModel movie = new MovieModel(id,title,genre,budget,duration);
		movieService.addMovie(movie);
		return "add";
	}
	
	@RequestMapping("/movie/view") 
	public String view(@RequestParam("id") String id, Model model) { 
		MovieModel archieve = movieService.getMovieDetail(id);
		model.addAttribute("movie", archieve); 
		return "view-movie"; 
	}
	
	@RequestMapping(value = {"/movie/delete/", "movie/delete/{id}" })
	public String delete(@PathVariable Optional<String> id, Model model) {
		List<MovieModel> archiveL = movieService.getMovieList();

		if (id.isPresent()) {
			for (MovieModel mobj : archiveL) {
				boolean isEqual = id.equals(Optional.of(mobj.getId()));
				if (isEqual) {
					while (archiveL.contains(Optional.of(mobj.getId()))) {
						archiveL.remove(mobj);
					}
					model.addAttribute("movie", movie);
					model.addAttribute("successDelete", true);
				}

			}
		} else {
			model.addAttribute("failDelete", true);
			model.addAttribute("movie", movie);
		}

		return "view-movie";
	}

	
	@RequestMapping(value={"/movie/update/","/movie/update/{id}/duration/{duration}"})
	public String helloPath(@PathVariable Optional<String> id,
			@PathVariable Integer duration, Model model) {

		List<MovieModel> archiveList = movieService.getMovieList();
		
		if (id.isPresent()) {
			for (int i = 0; i < archiveList.size(); i++) {
				MovieModel movMod = archiveList.get(i);
				if (id.equals(Optional.of(movMod))) {
					MovieModel archiveM = movieService.getMovieDetail(id);
					archiveM.setDuration(duration);
					model.addAttribute("movie", archiveM);
				} else {
					model.addAttribute("error", true);
				}
			}
		} else {
			model.addAttribute("error", true);
		}

		return "view-movie";
	}
	
	@RequestMapping(value={"/movie/view/","/movie/view/{id}"})
	public String helloPath(@PathVariable Optional<String> id, Model model) {
		List<MovieModel> archiveList = movieService.getMovieList();
		
		if (id.isPresent()) {
			for (int i = 0; i < archiveList.size(); i++) {
				MovieModel movMod = archiveList.get(i);
				if (id.equals(Optional.of(movMod))) {
					MovieModel archiveM = movieService.getMovieDetail(id);
					model.addAttribute("movie", archiveM);
				} else {
					model.addAttribute("error", true);
				}
			}
		} else {
			model.addAttribute("error", true);
		}

		return "view-movie";
	}
	
	
	
	
	@RequestMapping("/movie/viewall")
	public String viewAll(Model model) {
		List<MovieModel> archieve = movieService.getMovieList();
		model.addAttribute("movies",archieve);
		return "viewall-movie";
	}
	
		
}
