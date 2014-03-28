package br.edu.curso.mockito.exercicio.matchers_args.correios;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import org.apache.commons.lang.NotImplementedException;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Telegrama {
	
	public String texto;
	public Date data;
	public Envelope envelope;
	
	public Telegrama(String texto, Date data) {
		this.texto = texto;
		this.data = data;
	}
	
	@SuppressWarnings("static-access")
	public TelegramaBuilder but() {
		return Telegrama.this.builder()
				.texto( this.texto )
				.data( this.data )
				.envelope( this.envelope );
	}
	
	class Funcionario {
		Telegrama preparar(String texto, Date data, Envelope envelope) {
			return Telegrama.builder().texto( texto ).data( data ).envelope( envelope ).build();
		}
	}
	
	class Despachador {
		public boolean entregar(Telegrama telegrama) {
			throw new NotImplementedException();
		}
	}

}