package br.edu.curso.teste.refactoring.pattern.templatemethod;

import static org.junit.Assert.assertTrue;

import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.vidageek.mirror.dsl.ClassController;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * <li>Caixa eletrônico que efetua pagamento de documentos <br/>
 * <li> Os documentos podem ser boleto e por transferência <br/>
 * <li> Apesar de existir tipos de documento diferentes eles realizam 
 * ações similares e outras específicas  
 * <br/><br/>
 * 
 * A idéia aqui é exercitar sobre como reusar as asserções para simplificar o teste
 */
@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.class)
public class CaixaTest {

	private ControladorCaixa caixa;
	private Conta conta;
	private Conta contaPoupanca;
	private ClassController<Caixa> controller;

	@Before
	public void before() {
		this.controller = new Mirror().on(Caixa.class);
		this.conta = new Conta(500);
		this.caixa = new ControladorCaixa(this.conta);
		this.contaPoupanca = new Conta(500);
	}

	@Test
	public void pagamentoBoleto() {
		Boleto boleto = Boleto.builder().numero(873).total(100).build();
		Protocolo protocolo = caixa.pagamento(boleto);

		assertTrue(conta.saldo == 400);
		Queue<Transacao> extrato = caixa.extrato();
		assertTrue(extrato.contains(protocolo.transacao));

		String log = String.format(Message.PAGAMENTO, boleto.numero,
				boleto.total);
		assertTrue(log().contains(log));
	}

	@Test
	public void transferenciaMesmoBancoContaCorrente() {
		Transferencia trans = Transferencia.builder().conta(contaPoupanca)
				.total(200).build();
		Protocolo protocolo = caixa.transferir(trans);

		assertTrue(this.conta.saldo == 300);
		assertTrue(this.contaPoupanca.saldo == 700);

		Queue<Transacao> extrato = caixa.extrato();
		assertTrue(extrato.contains(protocolo.transacao));

		String log = String.format(Message.TRANSFERENCIA, trans.conta.numero,
				trans.total);
		System.out.println(log);
		assertTrue(log().contains(log));
		for (String str : log()) {
			System.out.println(str);
		}

	}

	private Queue<String> log() {
		return (Queue<String>) controller.get().field("log");
	}

}