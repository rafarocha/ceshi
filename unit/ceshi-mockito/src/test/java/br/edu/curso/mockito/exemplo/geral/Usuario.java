
package br.edu.curso.mockito.exemplo.geral;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
import br.edu.curso.mockito.exemplo.geral.Historico.Fato;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Usuario {
	
	protected String id;
	protected String nome;
	
	protected Date ultimoLogin;
	protected Historico historico;
	
	public Usuario registrar(Fato fato) {
		historico.registrar( fato );
		return this;
	}
	
	class UsuarioRepository {
		public Usuario create(String userId) {
			return get( userId );
		}
		public Usuario get(String userId) {
			return Usuario.builder().id(userId).build();
		}
	}
	
}