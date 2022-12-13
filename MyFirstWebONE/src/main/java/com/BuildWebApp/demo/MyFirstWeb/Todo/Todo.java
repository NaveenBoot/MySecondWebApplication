package com.BuildWebApp.demo.MyFirstWeb.Todo;

import java.time.LocalDate;
import jakarta.validation.constraints.Size;

public class Todo {

	private int id;
	private String username;
	@Size(min=10,message="Enter Atleast 10 Characters")
	private String course;
	private LocalDate period;
	private boolean status;
	
	public Todo(int id, String username, String course, LocalDate period, boolean status) {
		super();
		this.id = id;
		this.username = username;
		this.course = course;
		this.period = period;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public LocalDate getPeriod() {
		return period;
	}

	public void setPeriod(LocalDate period) {
		this.period = period;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", course=" + course + ", period=" + period + ", status="
				+ status + "]";
	}
	
	
}
