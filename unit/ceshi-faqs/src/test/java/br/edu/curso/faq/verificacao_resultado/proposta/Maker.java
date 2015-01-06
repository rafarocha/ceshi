package br.edu.curso.faq.verificacao_resultado.proposta;

import java.util.PriorityQueue;

import br.edu.curso.faq.verificacao_resultado.proposta.Vaga.Funcao;

public class Maker {
	
	public static Carta criaCartaTrabalhadorDesempregadoComSelecaoApenasUmaVaga() {
		Vaga vaga = new Vaga(Funcao.Cozinheiro);
		
		final Contratacao contratacao = new Contratacao();
		contratacao.vaga = vaga;
		contratacao.quantidade = 1;
		
		Selecao selecao = new Selecao();
		selecao.quadro = new PriorityQueue<Contratacao>();
		selecao.quadro.add( contratacao );
		
		Trabalhador trabalhador = new Trabalhador();
		final Carta carta = new Carta(selecao, vaga, trabalhador);
		return carta;
	}

}