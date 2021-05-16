package org.demo.timetabling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class Lesson extends PanacheEntityBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String subject;	
	private String teacher;	
	private String studentGroup;
	
	@ManyToOne
	private Timeslot timeslot;
	@ManyToOne
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
