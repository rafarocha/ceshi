package br.edu.curso.mockito.exemplo.geral;


public interface Social {
	
	String  login (String uri);
	boolean logout(String uri);
	Dados obterDados(String token);
	
	abstract class All implements Social {
		public String login (String uri) {
			return null;
		}
		public boolean logout(String uri) {
			return false;
		}
		public Dados obterDados(String token) {
			return new Dados();
		}
	}
	
	class FacebookClient extends All implements Social {} 
	class TwitterClient  extends All implements Social {}
	
	class Dados {
		public String id;
		public String nome;
		public String email;
	}
	
}