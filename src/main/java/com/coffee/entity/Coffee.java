package com.coffee.entity;

import java.util.UUID;

//how to add uniqueness in id which should act as same as Primary key in database->UUID class
public class Coffee {
	private final String id;
	private String name;
	
	//constructor chaining
	public Coffee(String name) {
		this(UUID.randomUUID().toString(),name);
	}
	public Coffee(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
