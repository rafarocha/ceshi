package br.edu.curso.teste.refactoring.pattern.templatemethod;

import com.google.common.base.Objects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access=AccessLevel.PUBLIC)
public class Boleto implements Documento {

	public long numero;
	public double total;
	
	public long numero() {
		return numero;
	}
	public double total() {
		return total;
	}
	
	@Override public boolean equals(Object obj) {
		System.out.println( obj );
		if ( this == obj ) 	return true;
		if (obj == null) 	return false;
		if (getClass() != obj.getClass()) return false;
		
		final Boleto other = (Boleto) obj;
		if ( Objects.equal(this.numero, other.numero) ) {
			return true;
		}
		return false;
	}

	public void validar() {}
	
	@Override
	public String toString() {
		return String.format(Message.PAGAMENTO, this.numero, this.total);
	}
	
}