package com.app.tu03.model;

import java.util.Optional;

public class MovieModel {
	private String id;
	private String title;
	private String genre;
	private long budget;
	private Optional<Integer> duration;
	
	public MovieModel(String idc, String titlec, String genrec, Long budgetc, Optional<Integer> durationc) {
		super();
		this.id = idc;
		this.title = titlec;
		this.genre = genrec;
		this.budget = budgetc;
		this.duration = durationc;
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

	public void setDuration(Optional<Integer> duration) {
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

	public Optional<Integer> getDuration() {
		return duration;
	}
	
}
