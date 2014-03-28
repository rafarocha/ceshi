package br.edu.curso.mockito.exercicio.stubbing.game;

import org.apache.commons.lang.ArrayUtils;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.google.common.collect.Ranges;

public class ValidadorPosicao extends TypeSafeMatcher<Posicao> {
	
	public static final String range 
			= "coluna[a-j] e linha[1-10]";
	
	@Override protected boolean matchesSafely(Posicao posicao) {
		boolean colunaValida = this.colunaValida( posicao.coluna );
		boolean linhaValida = Ranges.closed( 1 , BatalhaNaval.Regras.tamanho).apply( posicao.linha );
		return colunaValida && linhaValida;
	}
	
	public void describeTo(Description desc) {
		desc.appendText( String.format(" permitido apenas %s ", range) );
	}
				
	private boolean colunaValida(String coluna) {
		return ArrayUtils.contains(BatalhaNaval.Regras.colunasPermitidas, coluna);
	}

	@Override
	public void describeMismatchSafely(final Posicao posicao, final Description desc) {
		desc.appendText(" palpite inválido ").appendValue( posicao );
	}	

}