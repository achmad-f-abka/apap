package com.apap.tu03.model;

public class MovieModel {
	private String id;
	private String title;
	private String genre;
	private Long budget;
	private Integer duration; //minutes

	public MovieModel(String id, String title, String genre, Long budget, Integer duration) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.budget = budget;
		this.duration = duration;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return this.id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGenre() {
		return this.genre;
	}
	
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	public Long getBudget() {
		return this.budget;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getDuration() {
		return this.duration;
	}
}
