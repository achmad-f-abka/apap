package com.apap.tu03.model;
/**
 * @author afriliadvi
 *
 */
public class MovieModel {
	private String id;
	private String title;
	private String genre;
	private long budget;
	private Integer duration; //minutes
	
	public MovieModel(String id, String title, String genre, long budget, Integer duration) {
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
		return id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setBudget(long budget) {
		this.budget = budget;
	}
	
	public long getBudget() {
		return budget;
	}
	
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	public Integer getDuration() {
		return duration;
	}

}
