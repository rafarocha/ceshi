package br.edu.curso.mockito.exercicio.interacao.game;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import br.edu.curso.mockito.exercicio.interacao.game.Dicionario.Tema;

// TODO tratar espacos para incluir palavras compostas ou com hífen
// TODO quando repetir letra que acertou, mostrar aviso, e se insistir, gameover com frase,: apelou!
// TODO randomizar o tipo: fruta, pais
public class ForcaTest {
	
	private Forca forca;
	
	private Dicionario dicionarioMock;
	private Desenhista desenhistaMock;
	private Coletor coletorMock;
	
    @Rule public TestName name = new TestName();
	
	@Before public void before() {
		// mocks
		this.dicionarioMock = mock( Dicionario.class );
		this.desenhistaMock = mock( Desenhista.class );
		this.coletorMock = mock( Coletor.class );
		
		// real
		this.forca = this.montarJogo();
		System.out.println( "\n\n#" + name.getMethodName() );
	}
	
	@Test public void acertoDireto() {
		when( dicionarioMock.eleger(any(Tema.class)) ).thenReturn("leopardo");
		when( coletorMock.obter() ).thenReturn( "l" );
		
		forca.jogar( Tema.animais );
		
		verify( desenhistaMock, never() ).desenha( anyInt() );
	}

	@Test public void acerto6Erros() {
		when( dicionarioMock.eleger(any(Tema.class)) ).thenReturn("leopardo");
		when( coletorMock.obter() ).thenReturn( "x", "y", "w" );
		
		forca.jogar( Tema.animais );
		
		verify( desenhistaMock, times(7) ).desenha( anyInt() );
	}
	
	private Forca montarJogo() {
		return Forca.builder()
				.dicionario( this.dicionarioMock )
				.desenhista( this.desenhistaMock )
				.coletor( coletorMock )
				.build();
	}
	
}