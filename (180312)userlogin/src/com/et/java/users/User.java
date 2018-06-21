package com.et.java.users;

public class User {
	
	public String id;
	
	public String passwode;
	
	public User(){}
	
	public User(String id,String passwode){
		this.id=id;
		this.passwode=passwode;
	}
	
	
	public void setId(String id){
		this.id=id;
	}
	
	
	public String getId(){
		return id;
	}
	
	
	public void setPasswode(String passwode){
		this.passwode=passwode;
	}
	
	
	public String getPasswode(){
		return passwode;
	}
	
}
