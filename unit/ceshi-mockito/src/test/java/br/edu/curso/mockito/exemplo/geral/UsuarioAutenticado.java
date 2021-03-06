package br.edu.curso.mockito.exemplo.geral;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class UsuarioAutenticado {
	
	public Usuario usuario;
	public String hash;
	public RedeSocial rede;

}