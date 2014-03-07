package br.edu.curso.teste.experimentos.junit.classrules;

public class Server {
	
	public boolean running = false;

	public void connect() {
		System.out.println( "server on" );
		running = true; 
	}

	public void disconnect() {
		System.out.println( "server shutdown" );
		running = false;
	}
	
	public boolean isRunning() {
		return running;
	}
	
}