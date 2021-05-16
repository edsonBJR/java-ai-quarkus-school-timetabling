package org.demo.timetabling.solver;

import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;

// Aqui estamos criando a classe que será reponsável por
// prover as informações referentes as nossas restrições 
// no projeto

public class TimeTableConstraintProvider implements ConstraintProvider {

	@Override
	public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
		return new Constraint[] {
				
		};
	}

}
