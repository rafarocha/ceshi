package br.edu.curso.teste.experimentos.mockito;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Preconditions;

public class Service {
	
	private Repository repository;
	
	public Service() {}
	public Service(Repository repository) {
		this.repository = repository;
	}
	public String message() {
		return repository.message();
	}
	public Model get(String id) {
		return this.repository.get(id);
	}
	public Model get(Model model) {
		return this.repository.get(model);
	}
	public Model getAndUpdate(String id) {
		Model model = get(id);
		this.repository.save(model);
		return model;
	}
	public void save(String id) {
		Model model = get(id);
		this.repository.save(model);
	}
	public void insert(String id) {
		Model model = get(id);
		try {
			this.valid(model);
			repository.save(model);
		} catch (IllegalStateException e) {
			repository.insert(model);
		}
	}

	public final String palavrao = "poxa";
	public final String msgValidacao = "não pode ter a palavra "
			.concat(palavrao);

	private void valid(Model model) {
		System.out.println("save in memory");
		Preconditions.checkArgument(StringUtils.isNotEmpty(model.id));
		Preconditions.checkArgument(!model.id.contains(palavrao),
				msgValidacao);
	}
	
}