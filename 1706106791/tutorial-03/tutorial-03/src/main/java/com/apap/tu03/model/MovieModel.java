package com.apap.tu03.model;

public class MovieModel {
	private String title;
	private String genre;
	private long budget;
	private Integer duration; //minutes
	private String id;
	
	private String getId() {
		return id;
	}
	private void setId(String id) {
		this.id = id;
	}
	private String getTitle() {
		return title;
	}
	private void setTitle(String title) {
		this.title = title;
	}
	private String getGenre() {
		return genre;
	}
	private void setGenre(String genre) {
		this.genre = genre;
	}
	private long getBudget() {
		return budget;
	}
	private void setBudget(long budget) {
		this.budget = budget;
	}
	private Integer getDuration() {
		return duration;
	}
	private void setDuration(Integer duration) {
		this.duration = duration;
	}
	private MovieModel(String title, String genre, long budget, Integer duration, String id) {
		super();
		this.title = title;
		this.genre = genre;
		this.budget = budget;
		this.duration = duration;
		this.id = id;
	}
	
	

}
