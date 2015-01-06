package br.edu.curso.hamcrest.exercicio.customizar_matchers;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

public class JuntaMilitar {
	
	public static final boolean temposPaz = true;
	
	public Iterable<Cidadao> selecao(List<Cidadao> cids) {
		return Iterables.filter(cids, requisito() );
	}

	@SuppressWarnings("unchecked")
	private Predicate<Cidadao> requisito() {
		return Predicates.and( Regras.RegrasAlistamento.exigencias ); 
	}
	
}