package br.edu.curso.hamcrest.exemplo.basico;

import static br.edu.curso.hamcrest.exemplo.basico.CombinaMatcher.all;
import static br.edu.curso.hamcrest.exemplo.basico.PessoaMatchers.hasIdade;
import static br.edu.curso.hamcrest.exemplo.basico.PessoaMatchers.hasIdadeFeatureMatcher;
import static br.edu.curso.hamcrest.exemplo.basico.PessoaMatchers.hasIdadeUsando_TypeSafeDiagnosingMatcher;
import static br.edu.curso.hamcrest.exemplo.basico.PessoaMatchers.hasNome;
import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.CoreMatchers.either;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * - hasIdade com BaseMatcher 	 
 * - hasNome com TypeSafeMatcher 
 * - hasIdadeUsando_TypeSafeDiagnosingMatcher
 * - hasIdadeFeatureMatcher
 * - última linha há uma combinação de matchers em mesma expressão
 * 
 * refs: 
 * [1] http://www.planetgeek.ch/2012/03/07/create-your-own-matcher/
 * [2] https://code.google.com/p/hamcrest/wiki/Tutorial  
 */
public class HamcrestCustomizadoTest {
	
	final Pessoa rocha = new Pessoa();
	
	@Test public void matchersBase() {
		assertThat(rocha, hasIdade(32));
		assertThat(rocha, hasNome("Rocha"));
		assertThat(rocha, hasIdadeUsando_TypeSafeDiagnosingMatcher(32));
	}
	
	@Test public void matchersCombinando() {
		assertThat(rocha, hasIdadeFeatureMatcher(32));
		assertThat(rocha, both( hasNome("Rocha") ).and( hasIdade(32) ) );
		
		assertThat(rocha, either(hasNome("Rochaa")).or( hasIdade(31) ));
	}
	
	@Test public void matchersCombinadorCustomizado() {
		assertThat(rocha, all( hasNome("Rocha")).and( hasIdade(32)) );
	}

}