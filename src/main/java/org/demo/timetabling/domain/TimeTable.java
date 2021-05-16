package org.demo.timetabling.domain;

import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

// Aqui temos a classe que será responsável por criar a solução
// nela vamos ter as listas de horario e de salas de aulas 
// disponíveis para que as aulas sejam distribuídas
@PlanningSolution
public class TimeTable {
	
	// Aqui conseguimos obter a lista de ids de horarios 
	// de aulas disponíveis para que sejam alocados
	// também estamos definindo que a entidade timeslot
	// será uma constraint para o Optaplanner analisar
	@ProblemFactCollectionProperty
	@ValueRangeProvider(id = "timeslotRange")
	private List<Timeslot> timeslotList;
	// Aqui conseguimor obter a lista de ids de salas
	// de aulas disponíveis para que sejam alocadas
	@ProblemFactCollectionProperty
	@ValueRangeProvider(id = "roomRange")
	private List<Room> roomList;
	
	@PlanningEntityCollectionProperty
	private List<Lesson> lessonList;
	
	// Aqui temos um atríbuto que será responsável por nos informar
	// a pontuação das nossas restrições
	// e irá informar quantas restrições rígidas e flexiveis foram
	// quebradas durante o planejamento
	@PlanningScore
	private HardSoftScore score;
	
	private SolverStatus solverStatus;
	
	public TimeTable() {}

	public TimeTable(List<Timeslot> timeslotList, List<Room> roomList, List<Lesson> lessonList) {
		this.timeslotList = timeslotList;
		this.roomList = roomList;
		this.lessonList = lessonList;
	}

	public List<Timeslot> getTimeslotList() {
		return timeslotList;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public List<Lesson> getLessonList() {
		return lessonList;
	}

	public SolverStatus getSolverStatus() {
		return solverStatus;
	}

	public void setSolverStatus(SolverStatus solverStatus) {
		this.solverStatus = solverStatus;
	}

	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}
	
}
