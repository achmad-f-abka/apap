package com.app.tu03.model;

import java.util.Optional;

public class MovieModel {
	private String id;
	private String title;
	private String genre;
	private long budget;
	private Integer duration;
	
	public MovieModel(String idx, String titlex, String genrex, Long budgetx, Integer durationx) {
		super();
		this.id = idx;
		this.title = titlex;
		this.genre = genrex;
		this.budget = budgetx;
		this.duration = durationx;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setBudget(long budget) {
		this.budget = budget;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public long getBudget() {
		return budget;
	}

	public Integer getDuration() {
		return duration;
	}
	
}
