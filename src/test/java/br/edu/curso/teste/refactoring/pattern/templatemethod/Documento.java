package br.edu.curso.teste.refactoring.pattern.templatemethod;

public interface Documento {
	
	double total();
	long numero();
	boolean equals(Object obj);
	void validar();

}