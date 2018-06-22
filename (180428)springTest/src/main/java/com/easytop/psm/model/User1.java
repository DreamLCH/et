package com.easytop.psm.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User1 {
	private int id;
	@Autowired
	private Person person;
	
	
	public User1() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User1(int id, Person person) {
		super();
		this.id = id;
		this.person = person;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", person=" + person + "]";
	}
	
	
}
