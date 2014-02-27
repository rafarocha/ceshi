package br.edu.curso.teste.refactoring.design_oo;

import java.util.Map;

import com.google.common.collect.Maps;

public class CopyOfComando {
	
	private ServicoA servicoA;
	private ServicoB servicoB;
	
	public void go(Chave chave) {
		Tipo tipo = this.mapa.get( chave );
		if ( tipo == null ) return;
		tipo.acao();
	}
	
	private Map<Chave, Tipo> mapa;
	
	public CopyOfComando() {
		this.mapa = Maps.newHashMap();
	}
	
	public CopyOfComando configure() {
		this.mapa.put(Chave.ALFA, 	injectServices(new TipoXH()) );
		this.mapa.put(Chave.DELTA, 	injectServices(new TipoYI()) );
		this.mapa.put(Chave.GAMA, 	injectServices(new TipoZJ()) );
		return this;
	}
	
	private Tipo injectServices(Tipo tipo) {
		tipo.config(servicoA, servicoB);
		return tipo;
	}
	
	private abstract class Tipo {
		abstract void acao();
		protected ServicoA sa;
		protected ServicoB sb;
		Tipo config(ServicoA sa, ServicoB sb) {
			this.sa = sa;
			this.sb = sb;
			return this;
		}
	}
	
	private class TipoXH extends Tipo {
		public void acao() {
			sa.acaoX();
			sb.acaoH();
		}
	}
	
	private class TipoYI extends Tipo {
		public void acao() {
			sa.acaoY();
			sb.acaoI();
		}
	}
	
	private class TipoZJ extends Tipo {
		public void acao() {
			sa.acaoZ();
			sb.acaoJ();
		}
	}
	
	interface ServicoA {
		void acaoX();
		void acaoY();
		void acaoZ();
	}
	
	interface ServicoB {
		void acaoH();
		void acaoI();
		void acaoJ();
	}
	
	enum Chave {
		DELTA, ALFA, GAMA
	}
	
} 