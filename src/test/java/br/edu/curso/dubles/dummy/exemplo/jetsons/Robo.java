package br.edu.curso.dubles.dummy.exemplo.jetsons;

import br.edu.curso.dubles.dummy.exemplo.jetsons.Local.ValidateLocal;

public class Robo {

	public String nome;
	public Local local;	
	public int bateria;
	
	public Robo(String nome) {
		this.nome = nome;
	}
	
	public void walk(Local local) {
		ValidateLocal.validate( local );
		this.local = local;
	}
	
}