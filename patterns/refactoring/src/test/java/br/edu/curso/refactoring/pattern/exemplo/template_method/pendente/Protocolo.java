package br.edu.curso.refactoring.pattern.exemplo.template_method.pendente;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access=AccessLevel.PACKAGE)
public class Protocolo {
	
	public Protocolo(){}
	
	public long numero;
	public Transacao transacao;
	public Date horario;
	
	public Protocolo compila(Transacao trans) {
		this.transacao = trans;
		this.numero = ( (long) Math.random() ); 
		return this;
	}
	
	@Override public String toString() {
		return "protocolo %s da transacao %s em %s no valor de %s";
	}
	
}