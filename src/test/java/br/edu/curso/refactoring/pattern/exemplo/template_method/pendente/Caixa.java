package br.edu.curso.refactoring.pattern.exemplo.template_method.pendente;

import java.util.Queue;

import com.google.common.collect.Queues;

public class Caixa {
	
	private static final Queue<String> log = Queues.newPriorityBlockingQueue();	
	private Conta conta;
	
	public Caixa(Conta conta) {
		this.conta = conta; // iniciando sessao		
	}
	
	public Transacao transferir(Transferencia doc) {
		doc.validar();
		Transacao trans = this.conta.transferir( doc );
		this.log( doc );
		return trans;
	}

	public Transacao pagar(Documento doc) {
		doc.validar();
		Transacao trans = this.conta.pagar( doc ); 
		this.log( doc );
		return trans;
	}
	
	public Queue<Transacao> extrato() {
		return this.conta.transacoes;
	}
	
	// refatorar abaixo
	public Protocolo protocolar(Transacao trans) {
		Protocolo protocolo = new Protocolo().compila( trans );
		this.log( protocolo );
		return protocolo;
	}	
	private void log(Protocolo protocolo) {
		log.add( protocolo.toString() );
	}
	private void log(Documento doc) {
		log.add( doc.toString() );
	}
	
}