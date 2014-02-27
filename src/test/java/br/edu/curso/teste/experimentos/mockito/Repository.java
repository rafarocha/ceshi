package br.edu.curso.teste.experimentos.mockito;

public class Repository {
	
	public void save(Model model) {
		System.out.println("save in memory");
	}

	public void insert(Model model) {
		System.out.println("insert in memory");
	}

	public Model get(String id) {
		return new Model(id);
	}
	
	public Model get(Model model) {
		return model;
	}
	public String message() {
		return "hello";
	}
	
}