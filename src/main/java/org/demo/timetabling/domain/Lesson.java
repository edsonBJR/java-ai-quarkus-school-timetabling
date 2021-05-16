package org.demo.timetabling.domain;

public class Lesson {

	private Long id;
	
	private String subject;	
	private String teacher;	
	private String studentGroup;
	
	private Timeslot timeslot;
	private Room room;
	
	public Lesson() {}

	public Lesson(String subject, String teacher, String studentGroup) {
		this.subject = subject;
		this.teacher = teacher;
		this.studentGroup = studentGroup;
	}

	public Long getId() {
		return id;
	}

	public String getSubject() {
		return subject;
	}

	public String getTeacher() {
		return teacher;
	}

	public String getStudentGroup() {
		return studentGroup;
	}

	public Timeslot getTimeslot() {
		return timeslot;
	}

	public Room getRoom() {
		return room;
	}
	
	@Override
	public String toString() {
		return subject + "[" + id + "]";
	}
	
}
