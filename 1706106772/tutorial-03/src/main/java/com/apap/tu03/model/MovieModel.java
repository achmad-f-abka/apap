package com.apap.tu03.model;

import java.util.Optional;

public class MovieModel {
	private String id;
	private String title;
	private String genre;
	private Long budget;
	private Optional <Integer> duration;
	
	public MovieModel(String id2, String title2, String genre2, long budget2, Optional<Integer> duration2) {
		// TODO Auto-generated constructor stub
		super();
		this.id = id2;
		this.title = title2;
		this.genre = genre2;
		this.budget = budget2;
		this.duration = duration2;

	}
	public void setId(String id) {
		this.id=id;
	}
	public String getId() {
		return this.id;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getTitle() {
		return this.title;
	}
	public void setGenre(String genre) {
		this.genre=genre;
	}
	public String getGenre() {
		return this.genre;
	}
	public void setBudget(Long budget) {
		this.budget=budget;
	}
	public Long getBudget() {
		return this.budget;
	}
	public void setDuration(Optional<Integer> duration) {
		this.duration=duration;
	}
	public Optional<Integer> getDuration() {
		return duration;
	}
	
}
