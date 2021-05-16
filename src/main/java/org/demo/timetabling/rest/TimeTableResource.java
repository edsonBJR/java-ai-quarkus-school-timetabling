package org.demo.timetabling.rest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.demo.timetabling.domain.Lesson;
import org.demo.timetabling.domain.Room;
import org.demo.timetabling.domain.TimeTable;
import org.demo.timetabling.domain.Timeslot;
import org.optaplanner.core.api.score.ScoreManager;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverManager;
import org.optaplanner.core.api.solver.SolverStatus;

@Path("/timeTable")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TimeTableResource {
	
	private static final long SINGLETON_TIME_TABLE_ID = 1L;
	@Inject
	SolverManager<TimeTable, Long> solverManager;
    @Inject
    ScoreManager<TimeTable, HardSoftScore> scoreManager;
	
	@GET
	public TimeTable getTimeTable() {
		SolverStatus solverStatus = solverManager.getSolverStatus(SINGLETON_TIME_TABLE_ID);
		TimeTable timeTable = findById(SINGLETON_TIME_TABLE_ID);
		scoreManager.updateScore(timeTable);
		timeTable.setSolverStatus(solverStatus);
		return timeTable;
	}
	
	@POST
	@Path("/solve")
	public void solve() {
		solverManager.solveAndListen(SINGLETON_TIME_TABLE_ID,
				this::findById, 
				this::save);
	}

	@Transactional
	protected TimeTable findById(Long id) {
		return new TimeTable(Timeslot.listAll(), 
				Room.listAll(), 
				Lesson.listAll()); 
	}
	
	@Transactional
	protected void save(TimeTable timeTable) {
		for(Lesson  lesson : timeTable.getLessonList()) {
			Lesson attachedLesson = Lesson.findById(lesson.getId());
			attachedLesson.setTimeslot(lesson.getTimeslot());
			attachedLesson.setRoom(lesson.getRoom());
		}
	}
}
