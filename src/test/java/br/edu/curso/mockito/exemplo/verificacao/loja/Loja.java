package br.edu.curso.mockito.exemplo.verificacao.loja;

import java.util.Date;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import org.apache.commons.lang.NotImplementedException;

import br.edu.curso.mockito.exemplo.geral.Historico;
import br.edu.curso.mockito.exemplo.geral.Usuario;
import br.edu.curso.mockito.exemplo.geral.Usuario.UsuarioBuilder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Loja {
	
	private Estoque estoque;
	private Receita receita;
	private Transportadora transportadora;
	private Financeiro financeiro;
	private Site site;
	
	public void comprar(Cliente cliente, Carrinho carrinho) {
		boolean temClienteNomeLimpo = receita.inadimplente( cliente );  
		if ( !temClienteNomeLimpo ) {
			throw new IllegalStateException("cliente nome sujo");
		}
		boolean temProdutosEstoque = estoque.possui( carrinho.produtos );
		if ( !temProdutosEstoque ) {
			throw new IllegalStateException("produto sem estoque");
		}
		
		Pedido pedido = financeiro.emitir( carrinho.produtos );
		NotaFiscal nota = financeiro.gerar( pedido );
		Date previsao = transportadora.entregar( pedido, nota );
		site.enviarEmail( cliente, previsao, pedido );
	}
	
	class Estoque {
		public boolean possui( List<Produto> produtos ) {
			throw new NotImplementedException(); 
		}
	}
	
	class Receita {
		public boolean inadimplente(Cliente cliente) {
			throw new NotImplementedException();
		}
	}
	
	public class Transportadora {
		public Date entregar(Pedido pedido, NotaFiscal nota) {
			throw new NotImplementedException();
		}
	}
	
	class Financeiro {
		public NotaFiscal gerar(Pedido pedido) {
			throw new NotImplementedException();
		}
		public Pedido emitir(List<Produto> produtos) {
			throw new NotImplementedException();
		}
	}

	class Produto {}

}