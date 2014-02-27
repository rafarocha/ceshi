package br.edu.curso.teste.experimentos.junit.theory;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;

public class PositiveIntegerParameterSupplier extends ParameterSupplier {

	private final Random random = new SecureRandom();

	@Override
	public List<PotentialAssignment> getValueSources(ParameterSignature sig) {
		List<PotentialAssignment> values = new ArrayList<PotentialAssignment>();

		for (int i = 0; i < 100; ++i) {
			int next = random.nextInt(Integer.MAX_VALUE);
			if (next == 0)
				next = Integer.MAX_VALUE;
			values.add(PotentialAssignment.forValue(Integer.toString(next),
					next));
		}

		return values;
	}

}