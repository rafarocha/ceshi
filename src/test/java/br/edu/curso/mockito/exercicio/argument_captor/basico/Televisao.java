package br.edu.curso.mockito.exercicio.argument_captor.basico;

public class Televisao {
	
	private Dispositivo dispositivo;
	
	public void mudar(int canal) {
		this.dispositivo.mudar( new Canal(canal) );
	}

}