package com.apap.tu03.model;

public class MovieModel {
	private String id;
	private String title;
	private String genre;
	private Long budget;
	private Integer duration; //minutes
	
	public MovieModel(String id, String title, String  genre, Long budget, Integer duration) {
		this.id=id;
		this.title=title;
		this.genre=genre;
		this.setBudget(budget);
		this.setDuration(duration);
	}
	public void setId(String id) {
		this.id=id;
	}
		public String getId() {
		return id;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public String getTitle() {
		return title;
	}
	public void setGenre(String genre) {
		this.genre=genre;
	}
	public String getGenre() {
		return genre;
	}
	public Long getBudget() {
		return budget;
	}
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	
}