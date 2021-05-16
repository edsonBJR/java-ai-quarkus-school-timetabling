package org.demo.timetabling.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Timeslot {
	
	private Long id;
	
	private DayOfWeek dayOfWeek;
	
	private LocalTime startTime;
	private LocalTime entTime;
	
	public Timeslot() {}

	public Timeslot(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime entTime) {
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.entTime = entTime;
	}

	public Long getId() {
		return id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEntTime() {
		return entTime;
	}
	
	@Override
	public String toString() {
		return dayOfWeek + " " + startTime;
	}

}
