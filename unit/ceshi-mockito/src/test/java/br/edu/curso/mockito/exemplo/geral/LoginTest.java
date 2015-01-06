package br.edu.curso.mockito.exemplo.geral;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import br.edu.curso.mockito.exemplo.geral.Historico.Fato;
import br.edu.curso.mockito.exemplo.geral.Social.Dados;
import br.edu.curso.mockito.exemplo.geral.Usuario.UsuarioRepository;

public class LoginTest {
	
	private LoginController login;
	
	private SocialService socialServiceMock;
	private UsuarioRepository usuarioRepositoryMock;
	private Registrador registradorMock;
	
	private static Dados dados = Maker.dados();
	
	@Before public void before() {
		// mocks
		this.socialServiceMock = mock( SocialService.class );
		this.usuarioRepositoryMock = mock( UsuarioRepository.class );
		this.registradorMock = mock( Registrador.class );
		
		// real
		this.login = configureLogin();
	}
	
	@Test public void sair() {
		// fixture ou criando cenário
		Usuario usuario = Usuario.builder().id( dados.id ).build();
		
		// chamando real
		this.login.sair( usuario );
		
		// verificando comportamento
		verify( registradorMock ).registrar(usuario, Fato.Saiu);
	}
	
	@Test public void registrarTwitter() {
		// fixture ou criando cenário
		LoginInfo info = Maker.loginInfo( RedeSocial.Twitter );
		
		// se comentar a linha abaixo o que acontece? e aí?
		when( socialServiceMock.login( any(LoginInfo.class) ) ).thenReturn( "_token_" );
		when( socialServiceMock.obterDados( anyString()) ).thenReturn( dados );
		
		// chamando real
		boolean autenticado = this.login.registrar( info );
		assertTrue( autenticado );
		
		// verificando comportamento
		verify( socialServiceMock ).login( info );
		verify( socialServiceMock ).obterDados( anyString() );
		
		verify( usuarioRepositoryMock ).create( dados.id );
		verify( registradorMock ).registrar( null, Fato.CriouConta, Fato.Entrou);
	}
	
	@Test(expected=ConnectionFailure.class) 
	public void registrarAoFalharConexao() {
		LoginInfo info = Maker.loginInfo( RedeSocial.Facebook );
		
		// forma 1 modo normal em métodos que retornam objetos
		when( socialServiceMock.obterDados( anyString() ) ).thenThrow( new ConnectionFailure() );
		
		this.login.registrar( info );		
	}
	
	private LoginController configureLogin() {
		return LoginController.builder()
				.socialService( this.socialServiceMock )
				.usuarioRepository( this.usuarioRepositoryMock )
				.registrador( this.registradorMock )
				.build();
	}
	
}