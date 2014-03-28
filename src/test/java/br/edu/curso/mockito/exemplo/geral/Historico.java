package br.edu.curso.mockito.exemplo.geral;

import java.util.Date;
import java.util.Queue;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Historico {

	protected Queue<Registro> registros;
	
	class Registro {
		public Date data;
		public Fato fato;
	}
	
	enum Fato {
		CriouConta, Entrou, Saiu;
	}

	public void registrar(Fato fato) {
		Registro registro = new Registro();
		switch( fato ) {
			case Entrou : case Saiu : {
				System.out.println ( registro.fato );
				break;
			}
			default :
		}
		registro.data = new Date();
		this.registros.add( registro );
	}
	
}