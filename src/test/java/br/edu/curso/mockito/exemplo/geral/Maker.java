package br.edu.curso.mockito.exemplo.geral;

import br.edu.curso.mockito.exemplo.geral.Social.Dados;
import br.edu.curso.mockito.exemplo.geral.Usuario.UsuarioRepository;

public class Maker {
	
	public static LoginInfo loginInfo(RedeSocial rede) {
		return LoginInfo.builder()
				.user("rocha")
					.pswd("123")
						.rede( rede )
				.build();
	}
	
	public static LoginController login(SocialService ser, UsuarioRepository repo, Registrador reg) {
		return LoginController.builder()
				.socialService( ser )
					.usuarioRepository( repo )
						.registrador( reg )
				.build();
	}
	
	public static Dados dados() {
		Dados dados = new Dados();
		dados.id = "silvio.santos";
		dados.nome = "Silvio Santos";
		dados.email = "silvio.santos@sbt.com";
		return dados;
	}

}