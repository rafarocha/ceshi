package br.edu.curso.hamcrest.exercicio.customizar_matchers;

import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Escolaridade.Medio;
import static br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Escolaridade.Superior;

import java.util.Arrays;

import br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Escolaridade;
import br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Nacionalidade;
import br.edu.curso.hamcrest.exercicio.customizar_matchers.Cidadao.Sexo;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Ranges;

public class Regras {

	@SuppressWarnings("unchecked")
	interface RegrasAlistamento {
		public Predicate<Cidadao> exigencias = 
	    		Predicates.and( 
	    				RegrasBasicas.idade18a21Anos, 
	    				RegrasBasicas.sexoMasculino,
	    				RegrasBasicas.temEnsinoMedio,
	    				RegrasBasicas.brasileira
	    		);
	}
	
	private interface RegrasBasicas {		
		Predicate<Cidadao> idade18a21Anos = new Predicate<Cidadao>() {
			public boolean apply(Cidadao cid) {
	        	return Ranges.closed(18, 21).apply( cid.idade );
	        }               
	    };
	    Predicate<Cidadao> sexoMasculino = new Predicate<Cidadao>() {
			public boolean apply(Cidadao cid) {
				if ( !JuntaMilitar.temposPaz ) return true;
	        	return cid.sexo.equals( Sexo.Masculino );
	        }               
	    };
	    Predicate<Cidadao> temEnsinoMedio = new Predicate<Cidadao>() {
			public boolean apply(Cidadao cid) {
				return Arrays.asList( aceitas() ).contains( cid.escolaridade );
	        }
			private Escolaridade[] aceitas() {
				return new Escolaridade[] { Medio, Superior };
			}
	    };
	    Predicate<Cidadao> brasileira = new Predicate<Cidadao>() {
			public boolean apply(Cidadao cid) {
	        	return cid.nacionalidade.equals( Nacionalidade.Brasileira );
	        }               
	    };
	}
	
}