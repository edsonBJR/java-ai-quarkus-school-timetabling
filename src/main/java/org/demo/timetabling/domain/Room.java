package org.demo.timetabling.domain;

public class Room {
	
	private Long id;
	
	private String name;
	
	public Room() {}

	public Room(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	

}
