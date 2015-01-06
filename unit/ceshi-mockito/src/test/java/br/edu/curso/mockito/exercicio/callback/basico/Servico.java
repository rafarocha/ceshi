package br.edu.curso.mockito.exercicio.callback.basico;

import br.edu.curso.mockito.exercicio.callback.basico.Projeto.Etapa;

public class Servico {
	
	private Repositorio repositorio;
	
	public void salvar(Etapa etapa) {
		this.repositorio.salvar(etapa);
	}
	public void salvar(Projeto projeto) {
		this.repositorio.salvar(projeto);		
	}
	
	interface Repositorio {
		public void salvar(Projeto projeto);
		public void salvar(Etapa etapa);
	}

}