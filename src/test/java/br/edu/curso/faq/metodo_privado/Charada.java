package br.edu.curso.faq.metodo_privado;

public class Charada {

	public static Resposta palpite(Opcao opcao) {
		opcao.validar();
		
		Resposta resposta = null;
		if ( opcao.porta % 2 == 0 )
			resposta = janela( opcao );
		else 
			resposta = gameover("porta", opcao.porta);
		
		System.out.println( resposta.mensagem() );
		return resposta;  
	}

	private static Resposta janela(Opcao opcao) {
		if ( opcao.janela() % 5 == 0 ) 
			return chave( opcao );
		return gameover("janela", opcao.janela());
	}
	
	private static Resposta chave(Opcao opcao) {
		if ( opcao.chave() % 3 == 0 ) 
			return anel( opcao );
		return gameover("chave", opcao.chave());
	}
	
	private static Resposta anel(Opcao opcao) {
		if ( opcao.anel() % 11 == 0 )
			return codigo( opcao );
		return gameover("anel", opcao.anel());
	}

	private static Resposta codigo(Opcao opcao) {
		if ( opcao.codigo() % 66 == 0 )
			return Resposta.Certa.configura( "n�mero", opcao.codigo() );
		return gameover("codigo", opcao.codigo());
	}

	private static Resposta gameover(String texto, int palpite) {
		return Resposta.Errada.configura(texto, palpite);
	}
	
	enum Resposta {
		Certa, Errada;
		private String mensagem;
		public Resposta configura(String palavra, Integer palpite) {
			String template = this.toString().concat( " : %s %s" );
			this.mensagem = String.format( template, palavra, palpite);
			return this;
		}
		public String mensagem() {
			return mensagem;
		}
		
	}
	
}