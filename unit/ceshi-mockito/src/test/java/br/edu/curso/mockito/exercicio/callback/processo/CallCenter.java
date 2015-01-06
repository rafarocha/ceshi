package br.edu.curso.mockito.exercicio.callback.processo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
import br.edu.curso.mockito.exercicio.callback.processo.Atendimento.Atendente;
import br.edu.curso.mockito.exercicio.callback.processo.Atendimento.Auditoria;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class CallCenter {
	
	private Atendente atendente;
	private Auditoria auditoria;
	
	public void atender(Cliente cliente) {
		Protocolo protocolo = atendente.atender( cliente );
		Atendimento atendimento = this.registrar( protocolo );
		this.obterAvaliacao(cliente, atendimento); 
		
		if ( !atendimento.bemSucedido() ) {
			atendimento.necessitaAcompanhamento();
		}
		
		auditoria.registrar( atendimento );
	}

	private void obterAvaliacao(Cliente cliente, Atendimento atendimento) {
		atendimento.nota = cliente.avaliar( atendimento );
	}
	
	public Atendimento registrar(Protocolo protocolo) {
		return Atendimento.builder()
				.protocolo( protocolo )
				.build();
	}

}