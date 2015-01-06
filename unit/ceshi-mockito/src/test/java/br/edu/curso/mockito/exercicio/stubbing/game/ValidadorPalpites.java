package br.edu.curso.mockito.exercicio.stubbing.game;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ValidadorPalpites extends TypeSafeMatcher<List<Posicao>> {
	
	private Posicao palpiteInvalido;
	
	public void describeTo(Description desc) {
		desc.appendText( " navio em posicionamento inválido " );
	}

	@Override
	protected boolean matchesSafely(List<Posicao> palpites) {
		ValidadorPosicao validadorPosicao = new ValidadorPosicao();
		
		for (Posicao palpite : palpites) {
			boolean palpiteValido = validadorPosicao.matches( palpite );
			
			if ( palpiteValido ) {
				continue;
			}
			
			this.palpiteInvalido = palpite;
			return false;
		}
		return true;
	}

	@Override
	public void describeMismatchSafely(final List<Posicao> navios, final Description desc) {
		desc.appendText(" palpite inválido ").appendValue( palpiteInvalido );
	}

}