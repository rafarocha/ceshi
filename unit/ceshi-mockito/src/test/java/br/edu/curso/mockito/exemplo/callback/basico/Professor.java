package br.edu.curso.mockito.exemplo.callback.basico;

public class Professor {
	
	private Aluno aluno;
	
	public void emitir() {
		Mensagem mensagem = new Mensagem("muito", "obrigado!");
		aluno.recebe( mensagem );
	}

}