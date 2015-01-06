package br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia;

import java.util.List;

import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Funcionalidade;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Ideia;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Modelo;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Projeto;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Prototipo;

public interface Processo {
	
	public interface Analista {
		Modelo modelar(Ideia financeiro);
	}
	public interface Designer {
		Prototipo prototipar(Ideia financeiro);
	}
	public interface Arquiteto {
		Projeto projetar(Pacote pacote);
	}
	public interface Programador {
		Sistema desenvolver(Pacote pacote, Projeto projeto);
	}	
	public interface Cliente {
		List<Funcionalidade> aprovar(Prototipo p, Modelo m);
	}

}