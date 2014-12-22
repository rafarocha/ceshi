package br.edu.curso.mockito.exercicio.verificacao.listas;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InOrder;

@SuppressWarnings("unchecked")
public class ListaTest {
	
	private List<String> lista1Mock = mock(List.class);
	private List<String> lista2Mock = mock(List.class);
	
	@Before public void before() {
		this.lista1Mock = mock(List.class);
		this.lista2Mock = mock(List.class);
	}
	
	@Test public void desafio1() {
		// aqui faça as mesmas chamadas feitas na verificação abaixo
		
		InOrder inOrder = inOrder( lista1Mock );
		
		lista1Mock.add("primeiro");
		lista1Mock.add("segundo");
		
		inOrder.verify(lista1Mock).add("primeiro");
		inOrder.verify(lista1Mock).add("segundo");
	}
	
	@Test @Ignore public void desafio2() {
		// aqui faça as mesmas chamadas feitas na verificação abaixo
		
		InOrder inOrder = inOrder(lista1Mock, lista2Mock);
		
		// aqui insira o InOrder
		lista1Mock.add("primeiro");		
		lista2Mock.add("segundo");		
		lista1Mock.add("terceiro");		
		
		inOrder.verify(lista1Mock).add("primeiro");
		inOrder.verify(lista2Mock).add("segundo");
		inOrder.verify(lista1Mock).add("terceiro");
	}

}