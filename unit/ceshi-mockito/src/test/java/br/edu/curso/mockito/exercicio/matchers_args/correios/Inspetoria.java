package br.edu.curso.mockito.exercicio.matchers_args.correios;

public interface Inspetoria {
	
	boolean validar(Telegrama telegrama);
	
	interface Observador {
		void escuta(String texto);
	}
	
	class NSA implements Inspetoria, Observador {
		public static final String alvo = "petroleo";
		public void escuta(String texto) {
			if ( texto.contains(alvo) ) {
				notifica( texto );
			}
		}
		public void notifica(String texto) {
			System.out.println( "enviando e-mail para Obama > ".concat(texto) );
		}
		public boolean validar(Telegrama telegrama) {
			escuta( telegrama.texto );
			return true;
		}
	}

}