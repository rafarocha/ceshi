package br.edu.curso.mockito.exercicio.callback.basico;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;

public class Projeto {
	
	public List<Etapa> etapas;
	public Date conclusao;
	
	public boolean concluido() {
		for (Etapa etapa : etapas) {
			if ( !etapa.concluido )
				return false;
		}
		return true;
	}
	
	public Projeto concluir() {
		this.conclusao = new Date();
		return this;
	}
	
	public void atualizar() {
		if ( concluido() && this.conclusao == null ) {
			this.concluir();
		}
	}
	
	public Projeto(Etapa ... etapas) {
		throw new NotImplementedException();
	}
	
	class Etapa {
		public Projeto projeto;
		public boolean concluido;
		public void concluir() {
			this.concluido = true;
			projeto.atualizar();
		}
	}

}