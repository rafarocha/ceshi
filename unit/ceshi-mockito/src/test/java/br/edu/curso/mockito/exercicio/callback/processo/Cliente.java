package br.edu.curso.mockito.exercicio.callback.processo;

import br.edu.curso.util.Util;
import br.edu.curso.util.Util.Algoritmo;

public class Cliente {
	
	public String id;
	public String nome;
	public Solicitacao solicitacao;
	
	public Cliente(String nome, Servico servico) {
		this.nome = nome;
		this.id = Util.hash(Algoritmo.MD5, this.nome);
		this.solicitacao = new Solicitacao(servico);
	}
	
	public Nota avaliar(Atendimento atendimento) {
		return ( solicitacao.atendida ) ? Nota.Bom : Nota.Pessimo;
	}
	
	class Solicitacao {
		public Solicitacao(Servico servico) {
			this.servico = servico;
		}
		public Servico servico;
		public boolean atendida;
	}
	
	enum Servico {
		Cancelar, MudarPlano, MudarVelocidade3G;
	}
	
	enum Nota {
		Pessimo, Bom;
	}

}