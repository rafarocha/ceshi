package br.edu.curso.teste.faq.metodo_privado;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Opcao {
	
	public int porta;
	public int janela;
	public int chave;
	public int anel;
	public int codigo;
	
	public int janela() {
		return porta + janela; 
	}
	
	public int chave() {
		return janela() + chave;
	}
	
	public int anel() {
		return chave() + anel;
	}
	
	public int codigo() {
		return anel() + codigo;
	}
	
	public void validar() {
		if ( codigo() == 0 || codigo() > 100 )
			throw new IllegalStateException("Não pode ser zero ou maior que 100");
	}
	
	@SuppressWarnings("static-access")
	public OpcaoBuilder but() {
		return Opcao.this.builder()
				.porta( this.porta )
				.janela( this.janela )
				.chave( this.chave )
				.anel( this.anel )
				.codigo( this.codigo );
	}
	
}