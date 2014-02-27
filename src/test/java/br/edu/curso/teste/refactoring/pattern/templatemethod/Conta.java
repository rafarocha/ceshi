package br.edu.curso.teste.refactoring.pattern.templatemethod;

import java.util.Date;
import java.util.Queue;
import java.util.Random;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import com.google.common.collect.Queues;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Conta {

	public Queue<Transacao> transacoes;
	public double saldo;
	public String numero;
	
	public Conta(double saldoInicial) {
		this.transacoes = Queues.newPriorityQueue();
		this.saldo = saldoInicial;
		this.numero = next();
	}

	public Transacao pagar(Documento doc) {
		this.validar(doc);
		return this.registra( doc );
	}
	
	public Transacao transferir(Transferencia trans) {
		trans.validar();
		this.saldo -= trans.total;
		trans.conta.saldo += trans.total;
		trans.conta.transacao( trans );
		return transacao( trans );
	}

	private Transacao registra(Documento doc) {
		this.saldo -= doc.total();
		return transacao( doc );
	}

	private Transacao transacao(Documento doc) {
		Transacao trans = this.criaTransacao( doc );
		this.add( trans );
		return trans;
	}
	
	private Transacao criaTransacao(Documento doc) {
		return Transacao.builder().documento(doc).horario(new Date()).build();
	}

	private void validar(Documento doc) {
		if (this.saldo >= doc.total()) return;
		throw new IllegalStateException();
	}
	
	private Conta add(Transacao transacao) {
		transacoes.add( transacao );
		return this;		
	}
	
	private String next() {
		return Integer.toString( new Random().nextInt(100000) );
	}

}