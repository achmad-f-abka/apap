package com.apap.tu03.model;

public class MovieModel {
	private String id;
	private String title;
	private String genre;
	private String budget;
	private String duration;
	
	
	public MovieModel(String id, String title, String genre, String budget, String duration) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.budget = budget;
		this.duration = duration;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
}
