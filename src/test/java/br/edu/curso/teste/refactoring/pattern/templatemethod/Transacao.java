package br.edu.curso.teste.refactoring.pattern.templatemethod;

import java.util.Date;

import com.google.common.base.Objects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Transacao {

	public Date horario;
	public Documento documento;
	public double valor;

	@Override public boolean equals(Object obj) {
		if ( this == obj ) 	return true;
		if (obj == null) 	return false;
		if (getClass() != obj.getClass()) return false;
		
		final Transacao other = (Transacao) obj;
		if ( Objects.equal(this.documento, other.documento) ) {
			return true;
		}
		return false;
	}
	
}