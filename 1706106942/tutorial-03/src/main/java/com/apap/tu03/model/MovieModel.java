package com.apap.tu03.model;

import java.util.Optional;

public class MovieModel {
	private String id;
	private String title;
	private String genre;
	private Long budget;
	private Integer duration; //minutes
	

	public MovieModel(String xid, String xtitle, String xgenre, Long xbudget, Integer xduration) {
		super();
		this.id=xid;
		this.title=xtitle;
		this.genre=xgenre;
		this.budget=xbudget;
		this.duration=xduration;
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
