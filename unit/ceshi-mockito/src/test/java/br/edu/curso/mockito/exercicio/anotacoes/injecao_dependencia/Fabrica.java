package br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Processo.Analista;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Processo.Arquiteto;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Processo.Cliente;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Processo.Designer;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Processo.Programador;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Funcionalidade;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Ideia;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Modelo;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Projeto;
import br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia.Sistema.Prototipo;

public class Fabrica {
	
	private Analista analista;
	private Designer designer;
	private Arquiteto arquiteto;
	private Programador programador;
	private Cliente cliente;
	
	public Sistema fabricar( Ideia ideia ) {
		Pacote pacote = this.prospectar(ideia);
		
		if ( this.clienteAprovou(pacote) ) {
			return this.desenvolver(pacote);
		}
		
		return null;
	}

	private Pacote prospectar(Ideia ideia) {
		Modelo modelo = analista.modelar( ideia );
		Prototipo prototipo = designer.prototipar( ideia );
		List<Funcionalidade> funs = cliente.aprovar(prototipo, modelo);
		
		return new Pacote( modelo, prototipo, funs );
	}
	
	private Sistema desenvolver(Pacote pacote) {
		Projeto projeto = arquiteto.projetar( pacote );
		return programador.desenvolver( pacote, projeto );
	}
	
	private boolean clienteAprovou(Pacote pacote) {
		return CollectionUtils.isNotEmpty( pacote.funcionalidades );
	}

}