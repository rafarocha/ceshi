package br.edu.curso.mockito.exemplo.argument_captor.fundamental;

import br.edu.curso.mockito.exemplo.argument_captor.fundamental.CifraCesarTest.Pombo;

public class Mensageiro {
	
	private Pombo pombo;
	
	public void enviar(String comando) {
		pombo.enviar( getSegredo(comando) );
	}
	
	private String getSegredo(String comando) {
		return String.format("%s:%s", cifra( destinatario() ), cifra(comando) );
	}
	
	private static final int CHAVE = 3;
	private String destinatario() {
		return "Colombo";
	}
	
	public String cifra(String mensagem) {
		return this.cifra(mensagem, CHAVE);
	}
	
	private String cifra(String mensagem, int chave){
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mensagem.length(); i++) {
            char c = (char)(mensagem.charAt(i) + chave);
            builder.append(c);
        }
        return builder.toString();
    }
 
    public String decifra(String mensagem){
        return cifra(mensagem, -CHAVE);
    }

}