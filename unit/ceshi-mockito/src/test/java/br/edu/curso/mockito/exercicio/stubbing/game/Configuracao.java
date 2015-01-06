package br.edu.curso.mockito.exercicio.stubbing.game;

import java.util.List;
import java.util.Random;

import br.edu.curso.mockito.exercicio.stubbing.game.BatalhaNaval.Nivel;

import com.google.common.collect.Lists;

public abstract class Configuracao {
	
	public List<Posicao> palpites;
	public List<Navio> navios;
	
	public Configuracao() {
		this.palpites = Lists.newArrayList();
		this.navios = Lists.newArrayList();
		this.configurar();
	}
	
	abstract public void configurar();
	
	protected void palpitar(String ... chutes) {
		for (String chute : chutes) {
			palpites.add( new Posicao(chute) );
		}
	}
	protected void configurar(String ... opcoes) {
		for (String opcao : opcoes) {
			String[] p = opcao.split(":");
			navios.add( new Navio(p[0], p[1]) );
		}
	}
	
	public String[] criaPalpitesProprios(Nivel nivel) {
		final int qtde = BatalhaNaval.Regras.palpitesPermitidos * nivel.peso;
		String[] palpites = new String[qtde];
		for (int i = 0; i < qtde; i++) {
			palpites[i] = col() + lin();
		}
		return palpites;
	}
	
	public String[] criaConfiguracaoPropria() {
		return new String[] {
			col() + lin() + ":" + col() + lin()
		};
	}
	
	
	public String col() {
		final Random random = new Random();
		int index = random.nextInt( BatalhaNaval.Regras.tamanho );
		return BatalhaNaval.Regras.colunasPermitidas[index];
	}
	
	public int lin() {
		final Random random = new Random();
		return 1 + random.nextInt( BatalhaNaval.Regras.tamanho );	
	}

}