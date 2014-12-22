package br.edu.curso.hamcrest.exercicio.customizar_matchers;

import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Regras.RegrasAlistamento.exigencias;

import static br.edu.curso.hamcrest.exercicio.customizar_matchers.VolutariosMaker.voluntarios;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;

public class JuntaMilitarTest {
	
	private List<Cidadao> cidadaos = voluntarios();
	private JuntaMilitar junta;
	
	@Before public void before() {
		this.junta = new JuntaMilitar();
		this.cidadaos = voluntarios();;
	}
	
	@Test public void aptos() {
		Iterable<Cidadao> aptos = junta.selecao( cidadaos );
		assertThat( aptos, new MatcherJuntaMilitar() );
	}	
	
	class MatcherJuntaMilitar extends TypeSafeMatcher<Iterable<Cidadao>> {
		private Cidadao cidadao;
		@Override public void describeTo(Description description) {
			description.appendText("deveria retornar ").appendValue( cidadao );
		}

		@Override
		protected boolean matchesSafely(Iterable<Cidadao> cidadaos) {
			for (Cidadao item : cidadaos) {
				if ( exigencias.apply( item ) )
					continue;
				this.cidadao = item;
				return false;
			}
			return true;
		}
		
	}

}