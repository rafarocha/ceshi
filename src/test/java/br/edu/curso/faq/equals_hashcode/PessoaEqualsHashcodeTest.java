package br.edu.curso.faq.equals_hashcode;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * equals 
 * http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#equals(java.lang.Object)
 * 
 * hashcode
 * http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode()
 */
public class PessoaEqualsHashcodeTest {
	
	private static final int NUM_ITERACOES = 5;
	
	private Pessoa pa;
	private Pessoa pb;
	private Pessoa pc;
	
	@Before public void before() {
		pa = Pessoa.builder().nome("rafa").sobrenome("rocha").build();
		pb = Pessoa.builder().nome("rocha").sobrenome("rafa").build();
		pc = Pessoa.builder().nome("mone").sobrenome("lima").build();
	}
	
	@Test public void equalsContraOutrosObjetos() {
		assertThat ( pa, not(new Object()) );
		assertFalse( pa.equals( Produto.builder().build() ) );   
	}
	
	@Test public void equalsNomeSobrenomeDiferentes() {
		assertThat( pa, not(pb) );
		assertThat( pb, not(pa) );
		assertThat( pb, not(pc) );
		assertThat( pc, not(pb) );
	}
	
	@Test public void equalsNomeSobremomeNulo() {
		pa = Pessoa.builder().nome( null ).sobrenome("rocha").build();
		assertThat( pa, not(pb) );
		assertThat( pb, not(pa) );
		
		pa = Pessoa.builder().nome( "rafa" ).sobrenome( null ).build();
		assertThat( pa, not(pb) );
		assertThat( pb, not(pa) );
	}
	
	@Test public void equalsNomeSobrenomeComEspaco() {
		pa = Pessoa.builder().nome( " rafa " ).sobrenome( " rocha " ).build();
		assertThat( pa, not(pb) );
		assertThat( pb, not(pa) );		
	}
	
	@Test public void equalsSimetrico() {
		pa = Pessoa.builder().nome( "rafa" ).sobrenome("rocha").build();
		pb = Pessoa.builder().nome( "rafa" ).sobrenome("rocha").build();
		assertThat( pa, is(pb) );
		assertThat( pb, is(pa) );
	}
	
	@Test public void equalsReflexivo() {
		assertThat( pa, is(pa) );
		assertThat( pb, is(pb) );
		assertThat( pc, is(pc) );
	}
	
	@Test public void equalsTransitivo() {
		configureNomeSobrenomeIguais();
		assertThat( pa, is(pb) );
		assertThat( pb, is(pc) );
	}

	@Test public void equalsNulo() {
		Object o = null;
		assertThat( pa, not( o ) );
		assertThat( null, not( pa ) );		
		assertThat( pb, not( o ) );
		assertThat( pc, not( o ) );
	}
	
	@Test public void equalsConsistente() {
		 for (int i = 0; i < NUM_ITERACOES; ++i) {
			 before();
			 
			 equalsContraOutrosObjetos();
			 equalsNomeSobremomeNulo();
			 equalsNomeSobrenomeDiferentes();
			 equalsNomeSobrenomeComEspaco();
			 
			 equalsSimetrico();
			 equalsReflexivo();
			 equalsTransitivo();
			 equalsNulo();
		 }
	}
	
	@Test public void hashCodeEqualsTrue() {
		configureNomeSobrenomeIguais();
		assertThat( "1st vs. 2nd", pa.hashCode(), is( pb.hashCode() ) );
		assertThat( "1st vs. 3rd", pa.hashCode(), is( pc.hashCode() ) );
		assertThat( "2nd vs. 3rd", pb.hashCode(), is( pc.hashCode() ) );
	}
	
	@Test public void hashCodeEqualsFalse() {
		assertThat( "1st vs. 2nd", pa.hashCode(), not( pb.hashCode() ) );
		assertThat( "1st vs. 3rd", pa.hashCode(), not( pc.hashCode() ) );
		assertThat( "2nd vs. 3rd", pb.hashCode(), not( pc.hashCode() ) );
	}
	
	@Test public void hashCodeConsistente() {
		for (int i = 0; i < NUM_ITERACOES; ++i) {			 
			 hashCodeEqualsTrue();
			 before();
			 hashCodeEqualsFalse();
		}
	}
	
	private void configureNomeSobrenomeIguais() {
		pa = Pessoa.builder().nome("rafa").sobrenome("rocha").build();
		pb = Pessoa.builder().nome("rafa").sobrenome("rocha").build();
		pc = Pessoa.builder().nome("rafa").sobrenome("rocha").build();
	}
	
}