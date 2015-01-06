package br.edu.curso.mockito.exercicio.callback.basico;

import br.edu.curso.mockito.exercicio.callback.basico.Projeto.Etapa;

public class Controller {

	private Servico servico;

	public String concluir(Etapa etapa) {
		etapa.concluir();
		this.servico.salvar( etapa );

		if ( etapa.projeto.concluido() ) {
			this.servico.salvar( etapa.projeto );
		}
		return "consulta";
	}

}