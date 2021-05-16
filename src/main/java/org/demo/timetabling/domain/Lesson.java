package org.demo.timetabling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

// Essa é entidade que será responsável pelo planejamento
@PlanningEntity
@Entity
public class Lesson extends PanacheEntityBase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String subject;	
	private String teacher;	
	private String studentGroup;
	
	// Aqui temos as variveis que serão alteradas no planejamento
	// O optaplanner vai utilizar um range de id's da entidade timeslot
	// para que ele mesmo consiga alocar uma aula em um determinado horário
	@PlanningVariable(valueRangeProviderRefs = "timeslotRange")
	@ManyToOne
	private Timeslot timeslot;
	
	// Aqui temos as variaveis que serão alteradas referente
	// a escolha da melhor sala de aula, atraves dos id's
	// das salas de aula o Optaplanner irá escolher a ideal para
	// cada aula
	@PlanningVariable(valueRangeProviderRefs = "roomRange")
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
	
	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}

	public Room getRoom() {
		return room;
	}
	
	public void setRoom(Room room) {
		this.room = room;
	}
	
	@Override
	public String toString() {
		return subject + "[" + id + "]";
	}
	
}
