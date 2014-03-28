package br.edu.curso.dubles.dummy.exemplo.jetsons;

import br.edu.curso.dubles.dummy.exemplo.jetsons.Objeto.Nave;

public class Jetson {
	
	public String nome;
	public Robo rosie;
	public ControleRemoto controle;
	
	public Jetson(String name) {
		this.nome = name;
		this.rosie = new Robo("rosie");
		this.controle = new ControleRemoto( this.rosie );
	}

	public void lavar(Nave nave) {
		this.controle.lavar( nave );
	}
	
}