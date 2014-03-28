package br.edu.curso.mockito.exercicio.callback.processo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import org.apache.commons.lang.NotImplementedException;

import br.edu.curso.mockito.exercicio.callback.processo.Cliente.Nota;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Atendimento {
	
	public Nota nota;
	public Protocolo protocolo;
	public boolean acompanhamento;
	
	public boolean bemSucedido() {
		return nota.equals( Nota.Bom );
	}
	
	public Atendimento necessitaAcompanhamento() {
		this.acompanhamento = true; 
		return this;
	}
	
	class Atendente {
		public Protocolo atender(Cliente cli) {
			throw new NotImplementedException();
		}
	}
	
	class Auditoria {
		public void registrar(Atendimento atendimento) {
			throw new NotImplementedException();
		}
	}

}