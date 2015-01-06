package br.edu.curso.mockito.exercicio.stubbing.game;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ValidadorConfiguracao extends TypeSafeMatcher<List<Navio>> {
	
	private Navio navioInvalido;
	
	public void describeTo(Description desc) {
		desc.appendText( " navio em posicionamento inválido " );
	}

	@Override
	protected boolean matchesSafely(List<Navio> navios) {
		ValidadorPosicao validadorPosicao = new ValidadorPosicao();
		
		for (Navio navio : navios) {
			boolean posicaoInicial = validadorPosicao.matches( navio.inicio );
			boolean posicaoFinal = validadorPosicao.matches( navio.fim );
			
			if ( posicaoInicial && posicaoFinal ) {
				continue;
			}
			
			this.navioInvalido = navio;
			return false;
		}
		return true;
	}

	@Override
	public void describeMismatchSafely(final List<Navio> navios, final Description desc) {
		desc.appendText(" navio em posição inválida ").appendValue( navioInvalido );
	}

}