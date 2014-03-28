package br.edu.curso.mockito.exemplo.geral;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
import br.edu.curso.mockito.exemplo.geral.Social.Dados;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SocialService {
	
	private Social social;
	
	public String login(LoginInfo info) throws ConnectionFailure {
		this.social = Suporte.obter( info.rede );
		return social.login( info.user + info.pswd );
	}
	
	public Dados obterDados(String token) {
		return social.obterDados( token );
	}
	
}