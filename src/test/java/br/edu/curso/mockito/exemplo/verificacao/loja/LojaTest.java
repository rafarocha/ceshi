package br.edu.curso.mockito.exemplo.verificacao.loja;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import br.edu.curso.mockito.exemplo.verificacao.loja.Loja.Estoque;
import br.edu.curso.mockito.exemplo.verificacao.loja.Loja.Financeiro;
import br.edu.curso.mockito.exemplo.verificacao.loja.Loja.Receita;
import br.edu.curso.mockito.exemplo.verificacao.loja.Loja.Transportadora;

public class LojaTest {
	
	private Loja loja;
	
	private Receita receitaMock;
	private Estoque estoqueMock;
	private Financeiro financeiroMock;
	private Transportadora transportadoraMock;
	private Site siteMock;
	
	@Before public void before() {
		// mocks
		this.receitaMock = mock( Receita.class ); 
		this.estoqueMock = mock( Estoque.class );
		this.financeiroMock = mock( Financeiro.class );
		this.transportadoraMock = mock( Transportadora.class );
		this.siteMock = mock( Site.class );
		
		// real
		this.loja = this.montarLoja();
	}
	
	@SuppressWarnings("unchecked")
	@Test public void ordemCompra() {
		Info info = new Info();
		
		//stubbing
		when( receitaMock.inadimplente( any(Cliente.class)) ).thenReturn( true );
		when( estoqueMock.possui( any(List.class)) ).thenReturn( true );
		when( financeiroMock.emitir( any(List.class)) ).thenReturn( info.pedido );
		when( financeiroMock.gerar( any(Pedido.class)) ).thenReturn( info.notaFiscal );
		when( transportadoraMock
				.entregar( any(Pedido.class), any(NotaFiscal.class) ))
						.thenReturn( info.previsao );
				
		// real
		loja.comprar( info.cliente, info.carrinho );
		
		// config ordem
		InOrder inOrder = Mockito.inOrder( receitaMock, estoqueMock, 
				financeiroMock, transportadoraMock, siteMock );
		
		// verificando ordem e comportamento
		inOrder.verify( receitaMock ).inadimplente( info.cliente );
		inOrder.verify( estoqueMock ).possui( info.carrinho.produtos );
		inOrder.verify( financeiroMock ).emitir( info.carrinho.produtos );
		inOrder.verify( financeiroMock ).gerar( info.pedido );
		inOrder.verify( transportadoraMock ).entregar( info.pedido, info.notaFiscal );		
		inOrder.verify( siteMock ).enviarEmail( info.cliente, info.previsao, info.pedido );		
	}
	
	class Info {
		public Carrinho carrinho = new Carrinho();
		public Pedido pedido = new Pedido();
		public NotaFiscal notaFiscal = new NotaFiscal();
		public Date previsao = new Date();
		public Cliente cliente = new Cliente();		
	}
	
	private Loja montarLoja() {
		return Loja.builder()
				.receita( this.receitaMock )
				.estoque( this.estoqueMock )
				.financeiro( this.financeiroMock )
				.transportadora( this.transportadoraMock )
				.site( siteMock )
				.build();
	}

}