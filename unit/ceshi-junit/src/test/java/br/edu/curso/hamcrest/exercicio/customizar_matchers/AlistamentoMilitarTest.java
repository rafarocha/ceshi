package br.edu.curso.hamcrest.exercicio.customizar_matchers;

import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Escolaridade.Medio;
import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Escolaridade.Superior;
import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Nacionalidade.Brasileira;
import static br.edu.curso.hamcrest.exercicio.customizar_matchers.VolutariosMaker.voluntarios;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Sexo;

import com.google.common.collect.Ranges;

public class AlistamentoMilitarTest {
	
	private List<Cidadao> pessoas = voluntarios();
	private JuntaMilitar junta = new JuntaMilitar();
	
	@Test public void aptosAlistamentoComAsserts() {
		Iterable<Cidadao> aptos = junta.selecao( pessoas );
		
		for (Cidadao cidadao : aptos) {
			assertTrue( Ranges.closed(18, 21).apply( cidadao.idade ) );
			if ( JuntaMilitar.temposPaz ) {
				assertEquals( Sexo.Masculino, cidadao.sexo );				
			}
			assertThat( cidadao.escolaridade, either( is(Medio) ).or( is(Superior) ) );
			assertThat( cidadao.nacionalidade, is(Brasileira) );
		}
	}
	
	// remover todo o código abaio, inclusive classe JuntaMilitarMatcher antes começar exercício
	@Test public void aptosAlistamentoComMatcherUnico() {
		Iterable<Cidadao> aptos = junta.selecao( pessoas );
		for (Cidadao cidadao : aptos) {
			assertThat( cidadao, JuntaMilitarMatcher.hasApto() );
		}
	}
	
	@Test public void aptosAlistamentoComMatcherVarios() {
		Iterable<Cidadao> aptos = junta.selecao( pessoas );
		assertThat( aptos, JuntaMilitarMatcher.hasAptos() );
	}
	
	public static void main(String[] args) {
		List<Cidadao> cidadaos = voluntarios();
		for (Cidadao cidadao : cidadaos) {
			assertThat(cidadao, JuntaMilitarMatcher.hasApto() );
		}
	}

}