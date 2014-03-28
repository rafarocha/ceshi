package br.edu.curso.mockito.exercicio.stubbing.game;

import com.google.common.base.Objects;

public class Posicao {

	public String coluna;
	public int linha;
	
	public Posicao(String pos) {
		try {
			this.coluna = String.valueOf( pos.charAt(0) );
			this.linha = Integer.parseInt( String.valueOf( pos.charAt(1) ) );			
		} catch (StringIndexOutOfBoundsException e) {
			throw new IllegalStateException("entrada invalida " + pos);
		}
	}
	
	public Posicao(String col, int lin) {
		this.coluna = col;
		this.linha = lin;
	}
	
	@Override public String toString() {
		String mensagem = "%s%s";
		return String.format(mensagem, coluna, linha);
	}
	
	@Override
	public boolean equals(Object obj) {
		if ( equalsInvalido(obj) ) {
			return false;
		}
		
		final Posicao posicao = (Posicao) obj;		
		return 
			this.equalsColuna( posicao ) &&
			this.equalsLinha ( posicao );
	}
	
	public boolean equalsColuna(Posicao posicao) {
		if ( equalsInvalido(posicao) ) {
			return false;
		}
		return Objects.equal( this.coluna, posicao.coluna );
	}

	public boolean equalsLinha(Posicao posicao) {
		if ( equalsInvalido(posicao) ) {
			return false;
		}
		return Objects.equal( this.linha, posicao.linha );
	}
	
	private boolean equalsInvalido(Object obj) {
		return (obj == null || getClass() != obj.getClass());
	}
	
}