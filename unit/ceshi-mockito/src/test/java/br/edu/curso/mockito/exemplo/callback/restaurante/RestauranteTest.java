package br.edu.curso.mockito.exemplo.callback.restaurante;

import static br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.ItemCardapio.X_Egg_Bacon;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import br.edu.curso.mockito.exemplo.callback.restaurante.Refeicao.Embalagem;
import br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.Atendente;
import br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.Cozinheiro;
import br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.ItemCardapio;

public class RestauranteTest {
	
	private Restaurante restaurante;
	
	private Cozinheiro cozinheiroMock;
	private Atendente atendenteMock; 
	private Refeicao xEggBacon;
	
	@Test public void deveTerEmbalagemCopa() {
		when( cozinheiroMock.preparar( any(ItemCardapio.class) ) )
			.thenReturn( xEggBacon );
		
		doAnswer( new AnswerRefeicaoComEmbalagemCopa() )
			.when( atendenteMock ).revisa( xEggBacon );
		
		Refeicao refeicao = restaurante.solicitar( X_Egg_Bacon );
		
		this.checar( X_Egg_Bacon, refeicao );
		this.checarEmbalagemCopa( refeicao );
	}
	
	
	class AnswerRefeicaoComEmbalagemCopa implements Answer<Refeicao> {
		public Refeicao answer(InvocationOnMock invocation) throws Throwable {
			Refeicao refeicao = getRefeicao( invocation );
			assertThat( Embalagem.Copa, is(refeicao.embalagem) );  
			return refeicao;
		}
		private Refeicao getRefeicao(InvocationOnMock invocation) {
			return (Refeicao) invocation.getArguments()[0];
		}
	}
	
	@Before public void before() {
		// mocks
		this.atendenteMock = mock( Atendente.class );
		this.cozinheiroMock = mock( Cozinheiro.class );
		
		// objetos reais
		this.restaurante = Restaurante.builder()
				.cozinheiro( cozinheiroMock )
				.atendente( atendenteMock )
				.build();
		
		this.xEggBacon = new Refeicao( ItemCardapio.X_Egg_Bacon );		
	}
	private void checarEmbalagemCopa(Refeicao refeicao) {
		assertThat( refeicao.embalagem, is(Embalagem.Copa) );
		this.checar( X_Egg_Bacon, refeicao );
	}
	
	private void checar(ItemCardapio item, Refeicao refeicao) {
		assertThat(item.ingredientes, containsInAnyOrder(refeicao.getIngredientes()) );
	}
	
}