package com.apap.tu03.model;

public class MovieModel {

		private String id;
		private String title;
		private String genre;
		private long budget;
		private Integer duration;	
	
	public MovieModel(String id, String title, String genre, long budget, Integer duration){
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.budget = budget;
		this.duration = duration;
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getGenre() {
		return this.genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public long getBudget() {
		return this.budget;
	}
	public void setBudget(long budget) {
		this.budget = budget;
	}
	
	public Integer getDuration() {
		return this.duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	

}
