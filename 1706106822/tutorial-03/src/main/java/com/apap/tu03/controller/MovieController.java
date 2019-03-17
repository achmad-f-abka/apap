package com.apap.tu03.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tu03.model.Movie;
import com.apap.tu03.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService movieService;

	@RequestMapping("/movie/add")
	public String add(@RequestParam(value="id",required=true)String id,
			@RequestParam(value="title",required=true)String title,
			@RequestParam(value="genre",required=true)String genre,
			@RequestParam(value="budget",required=true)Long budget,
			@RequestParam(value="duration",required=true)Integer duration) {
		Movie movie = new Movie(id,title,genre,budget,duration);
		movieService.addMovie(movie);
		return "add";
	}
	
	@RequestMapping("movie/view")
	public String view(@RequestParam("id")String id,Model model) {
		Movie archive=movieService.getMovieDetail(id);
		model.addAttribute("movie",archive);
		return "view-movie";
	}
	
	@RequestMapping("movie/viewall")
	public String viewAll(Model model) {
		List<Movie> archive = movieService.getMovieList();
		model.addAttribute("movie",archive);
		return "viewall-movie";
	}
	
	@RequestMapping(value= {"/movie/view","/movie/view/{id}"})
	public String viewMovie(@PathVariable String id,Model model) {
		Movie archive=movieService.getMovieDetail(id);
		if(archive!=null) {
			model.addAttribute("movie",archive);
			return "view-movie";
		}else{
			return "empty";
		}
	}
	
	@RequestMapping("/movie/update/{id}/duration/{duration}")
		public String addDuration(@PathVariable String id,@PathVariable Integer duration,Model model) {
			Movie archive=movieService.getMovieDetail(id);
			if(archive!=null) {
			int durasi=archive.getDuration()+duration;
			archive.setDuration(durasi);
			model.addAttribute("movie",archive);
			return "add-duration";
			}
			else {
			return "gagal-durasi";
			}
	}
	
	@RequestMapping("movie/delete/{id}")
	public String deleteMovie(@PathVariable String id,Model model) {
//		Movie archive=movieService.getMovieDetail(id);
		List<Movie> archive=movieService.getMovieList();
		if(archive.size()==0) {
			return "gagal-hapus";
		}else{
			for(int i=0;i<archive.size();i++) {
				if(archive.get(i).getId().equals(id)) {
					model.addAttribute("movie",archive.get(i));
					archive.remove(i);
					return "delete";
				}
			}
			return "gagal-hapus";
		}
		
	}
}
