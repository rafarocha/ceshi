package br.edu.curso.mockito.exemplo.callback.basico;

public class Aluno {
	
	public void recebe(Mensagem msg) {
		System.out.println( msg.x + " " + msg.y  );
	}

}