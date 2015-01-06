package br.edu.curso.mockito.exercicio.callback.processo;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
import br.edu.curso.mockito.exercicio.callback.processo.Cliente.Servico;

import com.google.common.base.Objects;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Protocolo {
	
	public Date data;
	public Servico servico;
	public String cliente;
	public String observacoes;
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass() ) {
			return false;
		}
		
		final Protocolo protocolo = (Protocolo) obj;		
		return Objects.equal( this.data, protocolo.data ) && 
					Objects.equal( this.servico, protocolo.servico ) &&
					Objects.equal( this.cliente, protocolo.cliente );
	}
	
}