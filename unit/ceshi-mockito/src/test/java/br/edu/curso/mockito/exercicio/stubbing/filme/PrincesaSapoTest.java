package br.edu.curso.mockito.exercicio.stubbing.filme;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import br.edu.curso.mockito.exercicio.stubbing.filme.Personagem.Ator;
import br.edu.curso.mockito.exercicio.stubbing.filme.Personagem.Atriz;

public class PrincesaSapoTest {
	
	private Cena cena;
	
	private Atriz atrizMock;
	private Ator atorMock;
	
	private Personagem sapoMock;
	private Personagem princesaMock;
	
	@Before public void before() {
		// mocks
		this.atrizMock = mock( Atriz.class );
		this.atorMock = mock( Ator.class );		

		this.sapoMock = mock( Personagem.class );
		this.princesaMock = mock( Personagem.class );
		
		// real
		this.cena = new Cena( atorMock, atrizMock );		
	}
	
	@Test public void quebrarFeitico() {
		when( atorMock.interpreta() ).thenReturn( sapoMock );
		when( atrizMock.interpreta() ).thenReturn( princesaMock );
		
		cena.acao();
		
		verify( princesaMock ).beija( sapoMock );
	}

}