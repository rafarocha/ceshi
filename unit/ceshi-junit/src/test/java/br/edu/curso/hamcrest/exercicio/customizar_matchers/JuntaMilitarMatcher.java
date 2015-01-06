package br.edu.curso.hamcrest.exercicio.customizar_matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import br.edu.curso.hamcrest.exercicio.customizar_matchers.Regras.RegrasAlistamento;

public class JuntaMilitarMatcher {
	
	public static Matcher<Cidadao> hasApto() {
		return new TypeSafeMatcher<Cidadao>() {
			public void describeTo(Description desc) {
				desc.appendText(" esperado ter aptidão para alistamento militar ");
			}

			@Override
			protected boolean matchesSafely(Cidadao cidadao) {
				return RegrasAlistamento.exigencias.apply( cidadao );
			}

			@Override
			public void describeMismatchSafely(final Cidadao cidadao, final Description desc) {
				desc.appendText(" mas não apto, oia quem foi: ").appendValue( cidadao.idade );
			}
		};
	}
	
	public static Matcher<Iterable<Cidadao>> hasAptos() {
		return new TypeSafeMatcher<Iterable<Cidadao>>() {
			private Cidadao naoApto;
			public void describeTo(Description desc) {
				desc.appendText(" esperado ter aptidão para alistamento militar ");
			}

			@Override
			protected boolean matchesSafely(Iterable<Cidadao> cidadaos) {
				for (Cidadao cidadao : cidadaos) {
					boolean apto = RegrasAlistamento.exigencias.apply( cidadao );
					this.naoApto = cidadao;
					if ( !apto ) return false; 
				}
				return true;
			}

			@Override
			public void describeMismatchSafely(Iterable<Cidadao> cidadaos, final Description desc) {
				desc.appendText(" mas não apto, oia quem foi: ").appendValue( naoApto.idade );
			}
		};
	} 

}