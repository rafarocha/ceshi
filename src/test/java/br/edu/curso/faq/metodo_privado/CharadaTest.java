package br.edu.curso.faq.metodo_privado;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class CharadaTest {
	
	public Opcao getOpcao() {
		return Opcao.builder().porta(0).janela(0).chave(0).anel(0).codigo(0).build();		
	}
	
	@Test @Ignore public void charada() {
		Opcao opcao = this.getOpcao();
		assertThat( opcao.codigo(), is( 66 ) );	
	}
	
}