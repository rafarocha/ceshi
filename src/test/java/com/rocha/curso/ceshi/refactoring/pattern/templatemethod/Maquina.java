package com.rocha.curso.ceshi.refactoring.pattern.templatemethod;

import java.util.Queue;
import java.util.Random;

import com.google.common.collect.Queues;

public class Maquina {
	
	private static final Queue<String> log = Queues.newPriorityBlockingQueue();
	
	public void log(String text) {
		log.add( text );
	}
	
	public void registra(Documento doc) {
		log.add( doc.toString() );
		Companhia com = sorteia();
		String msg = com.pagar( doc );
		log.add( msg );
	}
	
	public Companhia sorteia() {
		int numero = new Random().nextInt( Companhia.values().length ); 
		return Companhia.values()[numero]; // TODO possivel bug indexoutOfBounds
	}
	
	abstract class Documento {
		public long id;
		public double valor;
		public double total() {
			return this.valor;
		}
	}
	
	// TODO introduzir verificacao IF para cada metodo de documento para refatorar null object
	class Pagamento extends Documento {
		public double desconto;
		@Override public String toString() {
			return "pagamento realizado no valor de %d";
		}
		public double total() {
			return this.valor - desconto;
		}
	}
	
	class Multa extends Documento {
		public double juros;
		public double total() {
			return this.valor * juros;
		}
	}
	
	class Reembolso {
		
	}
	
	enum Companhia {
		GOL, AZUL, AA, TAM, WEBJET, AVIANCA, QATAR;
		
		public String pagar( Documento doc ) {
			return "pagamento realizado . transação #" + Transaction.next();
		}
	}
	
	
	static class Transaction {
		public static Random random = new Random();
		public static int next() {
			return random.nextInt(100000);
		}
	}

}