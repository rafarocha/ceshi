package br.edu.curso.mockito.exercicio.anotacoes.basico;

public class Maquina {
	
	private Motor motor;
	
	public Maquina(Motor motor) {
		this.motor = motor;
	}
	
	public void ligar(){
		motor.acionar();
	}

	class Motor {
		public void acionar(){}
	}

}