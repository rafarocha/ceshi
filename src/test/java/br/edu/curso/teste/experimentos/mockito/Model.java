package br.edu.curso.teste.experimentos.mockito;

import com.google.common.base.Objects;

public class Model {
	public Model(String id) {
		this.id = id;
	}

	public String id;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Model) {
			final Model other = (Model) obj;
			return Objects.equal(this.id, other.id);
		} else {
			return false;
		}
	}
}