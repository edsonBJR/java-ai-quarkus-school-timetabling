package org.demo.timetabling.rest;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Collections;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.demo.timetabling.domain.Lesson;
import org.demo.timetabling.domain.Room;
import org.demo.timetabling.domain.TimeTable;
import org.demo.timetabling.domain.Timeslot;

@Path("/timeTable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeTableResource {
	
	@GET
	public TimeTable getTimeTable() {
		Timeslot timeslot = new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30));
		Room room = new Room("Room A");
		Lesson lesson = new Lesson("Math", "A. Turing", "9th grade");
		return new TimeTable(
				Collections.singletonList(timeslot), Collections.singletonList(room), 
				Collections.singletonList(lesson));
	}

}
