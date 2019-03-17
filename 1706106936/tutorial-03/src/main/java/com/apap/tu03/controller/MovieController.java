package com.apap.tu03.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.apap.tu03.service.MovieService;
import com.apap.tu03.model.MovieModel;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping ("/movie/add")
	public String add(@RequestParam(value = "id", required = true) String id,
			@RequestParam(value = "title", required = true) String title,
			@RequestParam(value = "genre", required = true) String genre,
			@RequestParam(value = "budget", required = true) Long budget,
			@RequestParam(value = "duration", required = true) Integer duration) {
		MovieModel movie = new MovieModel (id,title,genre,budget,duration);
		movieService.addMovie(movie);
		return "add";
	}
	
	//di buat komen agar tidak bertabrakan dengan pathvariable
	/*
	@RequestMapping("/movie/view")
	public String view(@RequestParam(value = "id", required = false)String id, Model model) {
		MovieModel archive = movieService.getMovieDetail(id);
		model.addAttribute("movie", archive);
		return "view-movie";
	}
	*/
	
	@RequestMapping("/movie/viewall")
	public String viewAll(Model model) {
		List <MovieModel> archive = movieService.getMovieList();
		model.addAttribute("movies", archive);
		return "viewall-movie";
		}
	
	@RequestMapping(value = {"/movie/view","/movie/view/{movieid}"})
	public String view2(@PathVariable Optional<String> movieid, Model model ) {
		if(movieid.isPresent()) {
			String mvid = movieid.get();
			MovieModel archive = movieService.getMovieDetail(mvid);
			if (archive != null) {
				model.addAttribute("movie", archive);
				return "view-movie";
			}
			else {
				return "notfound";
			}
		}
		else {
			return "notfound";
		}
	}
	
	@RequestMapping(value= {"movie/update/","movie/update/{movieid}/{attr}/{val}"})
	public String updateMV (@PathVariable Optional<String> movieid, @PathVariable String attr, @PathVariable String val, Model model) {
		if(movieid.isPresent()) {
			String mvid = movieid.get();
			MovieModel archive = movieService.getMovieDetail(mvid);
			if (archive!= null) {
				archive.updateInfo(attr,val);
				model.addAttribute("movie", archive);
				return "update-success";
			}
			else {
				return "notfound";
			}
		}
		else {
			return "notfound";
		}
	}
	
	@RequestMapping (value = {"movie/delete/", "movie/delete/{movieid}"})
	public String deleteMV (@PathVariable Optional<String> movieid, Model model ) {
		if (movieid.isPresent()) {
			String mvid = movieid.get();
			MovieModel archive = movieService.getMovieDetail(mvid);
			if (archive != null) {
				movieService.deleteMovie(mvid);
				return "delete-success";
			}
			else {
				return "notfound";
			}
		}
		else {
			return "notfound";
		}
		
	}
}
