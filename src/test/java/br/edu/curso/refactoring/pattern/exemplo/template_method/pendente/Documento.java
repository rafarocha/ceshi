package br.edu.curso.refactoring.pattern.exemplo.template_method.pendente;

public interface Documento {
	
	double total();
	long numero();
	boolean equals(Object obj);
	void validar();

}