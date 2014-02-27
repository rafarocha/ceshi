package br.edu.curso.teste.refactoring.pattern.templatemethod;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access=AccessLevel.PUBLIC)
public class Transferencia implements Documento {

	public long numero;
	public Conta conta;
	public double total;
	
	public long numero() {
		return numero;
	}
	public double total() {
		return total;
	}
	
	public void validar() {
		if ( conta == null ) return;
		if ( conta.saldo > total ) return;
		throw new IllegalMonitorStateException();
	}
	
	@Override public String toString() {
		return String.format(Message.TRANSFERENCIA, this.conta.numero, this.total);
	}
	
}