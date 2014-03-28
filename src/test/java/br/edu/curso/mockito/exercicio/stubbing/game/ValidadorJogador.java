package br.edu.curso.mockito.exercicio.stubbing.game;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class ValidadorJogador extends TypeSafeMatcher<Jogador> {
	
	private StringBuilder builder = new StringBuilder();
	private Jogador jogador;
	
	@Override protected boolean matchesSafely(Jogador jogador) {
		this.jogador = jogador;
		return temNome() && temNavios() && temPalpites();
	}
	
	public void describeTo(Description desc) {
		desc.appendText( " jogador deve ter nome, palpites e configuração, válido! " );
	}
				
	@Override
	public void describeMismatchSafely(final Jogador jogador, final Description desc) {
		String texto = String.format( " jogador %s %s ", jogador, builder.toString() );
		desc.appendText( texto );
	}
	
	private boolean temNome() {
		boolean tem = ( StringUtils.isNotEmpty( jogador.nome ) );
		return incluirTexto( tem, " sem nome " );
	}
	
	private boolean temPalpites() {
		boolean tem = CollectionUtils.isNotEmpty( jogador.configuracao.palpites );
		return incluirTexto( tem, " sem palpites " );
	}
	
	private boolean temNavios() {
		boolean tem = CollectionUtils.isNotEmpty( jogador.configuracao.navios );
		return incluirTexto( tem, " sem configuração " );
	}
	
	private boolean incluirTexto(boolean tem, String msg) {
		String texto = tem ? StringUtils.EMPTY : msg;
		this.builder.append( texto );
		return tem;
	}

}