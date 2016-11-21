package com.tiy.ssa.exerciseWebApp.entity;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="exercise_category")
public class Exercise_Category implements Serializable {

	 private static final long serialVersionUID = 1L;
	    @Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		int id;
		
		@Column(name="description")
		String description;
		
		@Column(name="url")
		String url;
		
		@Column(name="explanation")
		String explanation;
		
//		@OneToMany(mappedBy="category")
//		private Set<Exercise> exercise;

		public String getUrl() {
			return url;
		}

		public String getExplanation() {
			return explanation;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public void setExplanation(String explanation) {
			this.explanation = explanation;
		}

			
		public Exercise_Category(String description, String url, String explanation) {
			super();
			this.description = description;
			this.url = url;
			this.explanation = explanation;
		}

		public Exercise_Category() {
		}


		public int getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		

		

		
}
