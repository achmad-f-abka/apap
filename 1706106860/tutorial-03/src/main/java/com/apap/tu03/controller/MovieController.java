package com.apap.tu03.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apap.tu03.model.MovieModel;
import com.apap.tu03.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/movie/add")
	public String add(@RequestParam(value="id", required=true) String id,
			@RequestParam(value="title", required=true) String title,
			@RequestParam(value="genre", required=true) String genre,
			@RequestParam(value="budget", required=true) Long budget,
			@RequestParam(value="duration", required=true) Integer duration) {
		MovieModel movie = new MovieModel(id,title,genre,budget,duration);
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
		model.addAttribute("movie",archive);
		return "viewall-movie";
	}
	
	@RequestMapping("/movie/view/{id}")
	public String viewMovie(@PathVariable Optional<String> id, Model model) {
		if(id.isPresent()) {
			for(MovieModel movie:movieService.getMovieList()) {
				if(movie.getId().equals(id.get())) {
					MovieModel archive = movieService.getMovieDetail(id.get());
					model.addAttribute("movie",archive);
					return "view-movie";
				}else {
					return "error";
					
				}
			}
		}else if(!id.isPresent()) {
			return "error";
			
		}
		return null;
	}
	
	@RequestMapping("/movie/update/{id}/duration/{duration}")
	public String updateDuration(@PathVariable Optional<String> id, @PathVariable Optional<Integer> duration, Model model) {
		if(id.isPresent()) {
			for(MovieModel movie:movieService.getMovieList()) {
				if(movie.getId().equals(id.get())) {
					String judul = movieService.getMovieDetail(id.get()).getTitle();
					int durasi = movieService.getMovieDetail(id.get()).getDuration();
					movieService.getMovieDetail(id.get()).setDuration(duration.get());
					int durasiBaru= duration.get();
					model.addAttribute("title", judul);
					model.addAttribute("movieDuration", durasi);
					model.addAttribute("newMovieDuration", durasiBaru);
					return "edit-duration";
					
				}else {
					return "edit-batal";
				}
			}
		}else if(!id.isPresent()) {
			return "edit-batal";
		}
		return null;
	} 
	
	@RequestMapping("/movie/delete/{id}")
	public String deleteMovie(@PathVariable Optional<String> id, Model model) {
		if(id.isPresent()) {
			for(MovieModel movie: movieService.getMovieList()) {
				if(movie.getId().equals(id.get())) {
					for (Iterator<MovieModel> iterasi = movieService.getMovieList().listIterator(); iterasi.hasNext(); ) {
					    MovieModel a = iterasi.next();
					    if (a.getId().equalsIgnoreCase(id.get())) {
					        iterasi.remove();
					    }
					}
					model.addAttribute("id", id.get());
					return "delete";
				}else {
					return "error";
					}
			}
		}else if (!id.isPresent()) {
			return "error";
			}
		return null;
	}
	
	}
	

