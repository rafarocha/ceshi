package br.edu.curso.hamcrest.exemplo.basico;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HamcrestBasicoTest {

	@Test
	public void usingAssertThat() {
		assertThat("xx", is("xx"));
		assertThat("yy", is(not("xx")));
		assertThat("i like cheese", containsString("cheese"));
	}
	
	@Test
	public void usingUsandoOutrosElementosEm() {
		// aquela lista de funcionalidades
		// outros tipos como data ..
		// site da wiki do hamcrest
	}
	
	// fazer exercicio usando codigo abaixo para checar se é NaN
	public static void main(String[] args) {
		double x = Math.sqrt(-8.0);
		System.out.println(x);
	}

}