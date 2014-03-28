package br.edu.curso.mockito.exemplo.geral;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
import br.edu.curso.mockito.exemplo.geral.Historico.Fato;
import br.edu.curso.mockito.exemplo.geral.Social.Dados;
import br.edu.curso.mockito.exemplo.geral.Usuario.UsuarioRepository;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class LoginController {
	
	protected SocialService socialService;
	protected Registrador registrador;
	
	protected UsuarioRepository usuarioRepository;
	protected UsuarioAutenticado autenticado; // imagine que está na sessão :)
	
	public boolean registrar(LoginInfo info) {
		String token = this.socialService.login( info );
		Dados dados = this.socialService.obterDados( token );
		
		return this.autenticarNoSite(dados, info.rede, token);
	}
	
	public void sair(Usuario usuario) { // por enquanto sem verificacao de senha
		registrador.registrar( usuario, Fato.Saiu );
	}

	private boolean autenticarNoSite(Dados dados, RedeSocial rede, String token) {
		Usuario usuario = criarConta( dados.id );

		this.autenticado = UsuarioAutenticado.builder()
			.hash( token )
				.rede( rede )
					.usuario( usuario )
			.build();
		return true;
	}

	private Usuario criarConta(String userId) {
		Usuario usuario = usuarioRepository.create( userId );
		registrador.registrar( usuario, Fato.CriouConta, Fato.Entrou );
		return usuario;
	}

}