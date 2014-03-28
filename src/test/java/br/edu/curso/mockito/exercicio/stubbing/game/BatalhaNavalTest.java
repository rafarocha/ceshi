package br.edu.curso.mockito.exercicio.stubbing.game;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import br.edu.curso.mockito.exercicio.stubbing.game.BatalhaNaval.Nivel;

public class BatalhaNavalTest {
	
	private Servidor servidorMock;
	private BatalhaNaval batalha;
	
	private Jogador bush;
	private Jogador obama;
	private Jogador et;
			
	@Before public void before() {
		// dados
		this.bush  = Oficina.jogador("Bush", "b2:b3", "a2" );
		this.obama = Oficina.jogador("Obama", "a2:a3", "a2-a1-a3" );
		this.et    = new Computador("E.T.", "", new Configuracao() {
			public void configurar() {
				String conf = col() + lin() + ":" + col() + lin();
				this.configurar( conf );
				this.palpitar( this.criaPalpitesProprios(Nivel.Insano) );
			}
		});
		
		// mock
		this.servidorMock = mock( Servidor.class );
		
		// real
		this.batalha = BatalhaNaval.builder().servidor( servidorMock ).build();
	}

	@Test public void bushPerde() {
		batalha.jogar(bush, et);
		Jogador vencedor = batalha.anunciarVencedor();
		assertThat( et, is(vencedor));
	}
	
	@Test public void bushVence() {
		batalha.jogar(bush, obama);
		Jogador vencedor = batalha.anunciarVencedor();
		assertThat( bush, is(vencedor));
	}
	
}