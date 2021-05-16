package org.demo.timetabling.bootstrap;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;

import org.demo.timetabling.domain.Lesson;
import org.demo.timetabling.domain.Room;
import org.demo.timetabling.domain.Timeslot;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class DemoDataGenerator {

	@Transactional
	public void generateDemoData(@Observes StartupEvent startupEvent) {
		List<Timeslot> timeslotList = new ArrayList<>();
        timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));

        timeslotList.add(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
        timeslotList.add(new Timeslot(DayOfWeek.TUESDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));
		Timeslot.persist(timeslotList);
		
        List<Room> roomList = new ArrayList<>();
        roomList.add(new Room("Sala A"));
        roomList.add(new Room("Sala B"));
        roomList.add(new Room("Sala C"));
		Room.persist(roomList);
		
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(new Lesson("Matemática", "A. Turing", "9° - Série"));
        lessonList.add(new Lesson("Matemática", "A. Turing", "9° - Série"));
        lessonList.add(new Lesson("Física", "M. Curie", "9° - Série"));
        lessonList.add(new Lesson("Química", "M. Curie", "9° - Série"));
        lessonList.add(new Lesson("Biologia", "C. Darwin", "9° - Série"));
        lessonList.add(new Lesson("História", "I. Jones", "9° - Série"));
        lessonList.add(new Lesson("Inglês", "I. Jones", "9° - Série"));
        lessonList.add(new Lesson("Inglês", "I. Jones", "9° - Série"));
        lessonList.add(new Lesson("Espanhol", "P. Cruz", "9° - Série"));
        lessonList.add(new Lesson("Espanhol", "P. Cruz", "9° - Série"));
        
        lessonList.add(new Lesson("Matemática", "A. Turing", "10° - Série"));
        lessonList.add(new Lesson("Matemática", "A. Turing", "10° - Série"));
        lessonList.add(new Lesson("Matemática", "A. Turing", "10° - Série"));
        lessonList.add(new Lesson("Física", "M. Curie", "10° - Série"));
        lessonList.add(new Lesson("Química", "M. Curie", "10° - Série"));
        lessonList.add(new Lesson("Francês", "M. Curie", "10° - Série"));
        lessonList.add(new Lesson("Geografia", "C. Darwin", "10° - Série"));
        lessonList.add(new Lesson("História", "I. Jones", "10° - Série"));
        lessonList.add(new Lesson("Inglês", "P. Cruz", "10° - Série"));
        lessonList.add(new Lesson("Espanhol", "P. Cruz", "10° - Série"));
		Lesson.persist(lessonList);
	}
}
