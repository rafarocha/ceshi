package br.edu.curso.dubles.dummy.exemplo.jetsons;

public interface Objeto {
	
	public interface Nave extends Objeto {
		int getAltimeter();  // altura em pés
		int getVariometer(); // velocidade de subida e descida
	}
	
}