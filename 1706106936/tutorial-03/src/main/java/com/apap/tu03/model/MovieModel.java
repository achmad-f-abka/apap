package com.apap.tu03.model;

public class MovieModel {
	private String id;
	private String title;
	private String genre;
	private Long budget;
	private Integer duration; //minutes
	
	//constructor kosong
		public MovieModel () {
			
		}
		
		/**
		 * Constructor parameter
		 * @param id id movie
		 * @param title judul movie
		 * @param genre genre movie
		 * @param budget budget movie
		 * @param duration durasi movie
		 */
		public MovieModel(String id, String title, String genre, Long budget, Integer duration) {
			this.id = id;
			this.title = title;
			this.genre = genre;
			this.budget = budget;
			this.duration = duration;
		}

		//setter id
		public void setId (String id) {
			this.id = id;
		}
		
		//getter id
		public String getId() {
			return this.id;
		}
		
		//setter title
		public void setTitle(String title) {
			this.title = title;
		}
		
		//getter title
		public String getTitle() {
			return this.title;
		}
		
		//setter genre
		public void setGenre(String genre) {
			this.genre = genre;
		}
		
		//getter genre
		public String getGenre() {
			return this.genre;
		}
		
		//setter budget
		public void setBudget(long budget) {
			this.budget = budget;
		}
		
		//getter budget
		public long getBudget() {
			return this.budget;
		}
		
		//setter duration
		public void setDuration (Integer duration) {
			this.duration = duration;
		}
		
		//getter duration
		public Integer getDuration () {
			return this.duration;
		}
		
		public void updateInfo(String attr, String val) {
			if(attr.equals("id")) {
				this.setId(val);
			}
			else if(attr.equals("title")) {
				this.setTitle(val);
			}
			else if(attr.equals("genre")) {
				this.setGenre(val);
			}
			else if(attr.equals("budget")) {
				this.setBudget(Long.parseLong(val));
			}
			else if(attr.equals("duration")) {
				this.setDuration(Integer.valueOf(val));
			}
	}
	
}
