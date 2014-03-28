package br.edu.curso.mockito.exercicio.stubbing.game;

import static br.edu.curso.mockito.exercicio.stubbing.game.BatalhaNaval.Regras.colunasPermitidas;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.collect.Ranges;

public class Navio {
	
	public String nome;
	public TipoNavio tipo;
	public Posicao inicio;
	public Posicao fim;
	
	public Navio(String ini, String fim) {
		this.inicio = new Posicao( ini );
		this.fim = new Posicao( fim );
	}
	
	public Navio(String ini, String fim, int x, int y) {
		this.inicio = new Posicao(ini, x);
		this.fim = new Posicao(fim, y);
	}
	
	@Override public String toString() {
		return inicio + ":" + fim;
	}
	
	public void contarAcertos(Jogador adversario) {
		for (Posicao posicao : adversario.configuracao.palpites) {
			if ( adversario.acertos.contains( posicao ) ) {
				continue; // já acertou
			}
			boolean acertou = this.acertou( posicao );
			if ( acertou ) {
				adversario.acertos.add( posicao );
			}
		}
	}
	
	public boolean acertou(Posicao pos) {
		if ( inicio.equals(pos) || fim.equals(pos) ) {
			return true;
		}
		
		boolean colIni = inicio.equalsColuna(pos);
		boolean colFim = fim.equalsColuna(pos);
		if ( colIni && colFim ) {
			return Ranges.closed(inicio.linha, fim.linha).apply( pos.linha );
		} // a2 - a4
		
		boolean linIni = inicio.equalsLinha(pos);
		boolean linFim = fim.equalsLinha(pos);
		if ( linIni && linFim ) {
			int i = this.indiceColuna( inicio.coluna );
			int f = this.indiceColuna( fim.coluna );
			int v = this.indiceColuna( pos.coluna );
			return Ranges.closed(i, f).apply( v );
		} // c5 - e5
		
		return false;
	}
	
	private int indiceColuna(String coluna) {
		return ArrayUtils.indexOf(colunasPermitidas, coluna);
	}
	
	enum TipoNavio{}

}