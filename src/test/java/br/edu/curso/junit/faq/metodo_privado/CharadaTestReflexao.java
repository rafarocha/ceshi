package br.edu.curso.junit.faq.metodo_privado;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;

import org.junit.Test;

import br.edu.curso.junit.faq.metodo_privado.Charada.Resposta;

public class CharadaTestReflexao {
	
	@Test public void charadaErrada() {
		Opcao opcao = Opcao.builder().codigo( 21 ).build();
		
		Method metodo = ReflexaoMirrorHelper.getMetodo("codigo", Charada.class, Opcao.class);
		Resposta resposta = ReflexaoMirrorHelper.invoke(metodo, Charada.class, opcao);
		
		assertThat( Resposta.Errada, is(resposta) );
		assertThat( "Errada : codigo 21", is(resposta.mensagem()) );
		
	}
	
}