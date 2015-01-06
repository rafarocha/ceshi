package br.edu.curso.sample.repositorio;

import javax.persistence.EntityManager;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
import br.edu.curso.sample.model.Usuario;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class UsuarioRepositorio {
	
	private EntityManager em;
	
	public Usuario obterPorId(int id) {
		return em.find(Usuario.class, id);
	}

}