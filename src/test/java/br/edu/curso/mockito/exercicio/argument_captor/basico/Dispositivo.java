package br.edu.curso.mockito.exercicio.argument_captor.basico;

public class Dispositivo {
	
	public void mudar(Canal canal) {
		System.out.println( "canal # " + canal.numero );
	}

}