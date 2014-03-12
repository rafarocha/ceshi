package br.edu.curso.refactoring.pattern.exemplo.template_method.pendente;

import java.util.Queue;

public class ControladorCaixa {
	
	private Caixa caixa;
	
	public ControladorCaixa(Conta conta) {
		this.caixa = new Caixa(conta);
	}
	
	public Protocolo pagamento(Documento doc) {
		Transacao trans = this.caixa.pagar(doc);
		return this.caixa.protocolar(trans);
	}
	
	public Protocolo transferir(Transferencia doc) {
		Transacao trans = this.caixa.transferir(doc);
		return this.caixa.protocolar(trans);
	}
	
	public Queue<Transacao> extrato() {
		return this.caixa.extrato();
	}

}