package br.edu.curso.mockito.exercicio.anotacoes.injecao_dependencia;

import java.util.List;

public class Sistema {	
	
	List<Funcionalidade> funcionalidade;
	
	public enum Ideia {
		Financeiro, Estoque;
	}
	
	public class Modelo {
		List<Requisito> requisitos;
	}
	
	public class Prototipo {}
	public class Projeto {}
	
	public class Funcionalidade {}
	public class Requisito {}	

}