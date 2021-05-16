package org.demo.timetabling.rest;

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
		return new TimeTable(Timeslot.listAll(), 
				Room.listAll(), 
				Lesson.listAll()); 
	}

}
