package org.demo.timetabling.solver;

import java.time.Duration;

import org.demo.timetabling.domain.Lesson;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

// Aqui estamos criando a classe que será reponsável por
// prover as informações referentes as nossas restrições 
// no projeto

public class TimeTableConstraintProvider implements ConstraintProvider {

	@Override
	public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
		return new Constraint[] {
				roomConflict(constraintFactory),
				teacherConflict(constraintFactory),
				studentGroupConflict(constraintFactory),
				teacherTimeEfficiency(constraintFactory)
		};
	}


	// Aqui definimos o método que será responsável por obter duas instâncias de aulas
	// e verificar se elas foram atribuída uma sala no mesmo momento
	// caso isso ocorra ele irá reorganizar as aulas em outras salas
	// também foi definido como uma restrição rigida que não pode ser quebrada
	private Constraint roomConflict(ConstraintFactory constraintFactory) {
		return constraintFactory.from(Lesson.class)
				.join(Lesson.class, 
						Joiners.equal(Lesson::getTimeslot), 
						Joiners.lessThan(Lesson::getId))
				.penalize("Room conflict", HardSoftScore.ONE_HARD);
	}
	
	private Constraint teacherConflict(ConstraintFactory constraintFactory) {
		return constraintFactory.from(Lesson.class)
				.join(Lesson.class, Joiners.equal(Lesson::getTimeslot), Joiners.equal(Lesson::getTeacher))
				.penalize("Teacher conflict", HardSoftScore.ONE_HARD);
	}
	
	private Constraint studentGroupConflict(ConstraintFactory constraintFactory) {
		return constraintFactory.from(Lesson.class)
				.join(Lesson.class, Joiners.equal(Lesson::getTimeslot), Joiners.equal(Lesson::getStudentGroup))
				.penalize("Student group conflict", HardSoftScore.ONE_HARD);
	}

	private Constraint teacherTimeEfficiency(ConstraintFactory constraintFactory) {
        return constraintFactory
                .from(Lesson.class)
                .join(Lesson.class, Joiners.equal(Lesson::getTeacher),
                        Joiners.equal((lesson) -> lesson.getTimeslot().getDayOfWeek()))
                .filter((lesson1, lesson2) -> {
                    Duration between = Duration.between(lesson1.getTimeslot().getEndTime(),
                            lesson2.getTimeslot().getStartTime());
                    return !between.isNegative() && between.compareTo(Duration.ofMinutes(30)) <= 0;
                })
                .reward("Teacher time efficiency", HardSoftScore.ONE_SOFT);
    }

}
