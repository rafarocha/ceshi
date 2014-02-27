package br.edu.curso.teste.experimentos.junit.theory;

import static org.hamcrest.Matchers.not;
import static org.junit.Assume.assumeThat;

import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;

public class TestOn {
	
	@Theory
	public void multiplyIsInverseOfDivideWithInlineDataPoints(
	        @TestedOn(ints = {0, 5, 10}) int amount,
	        @TestedOn(ints = {0, 1, 2}) int m
	) {
	    assumeThat(m, not(0));
//	    assertThat(new Dollar(amount).times(m).divideBy(m).getAmount(), is(amount));
	}

}