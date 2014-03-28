package br.edu.curso.mockito.exemplo.callback.restaurante;

import static br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.Ingrediente.Bacon;
import static br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.Ingrediente.Hamburguer;
import static br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.Ingrediente.Ovo;
import static br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.Ingrediente.Pao;
import static br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.Ingrediente.Queijo;
import static br.edu.curso.mockito.exemplo.callback.restaurante.Restaurante.Ingrediente.Verdura;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;
import br.edu.curso.mockito.exemplo.callback.restaurante.Refeicao.Embalagem;

import com.google.common.collect.Lists;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Restaurante {
	
	private Cozinheiro cozinheiro;
	private Atendente atendente;
	
	public Refeicao solicitar(ItemCardapio item) {
		Refeicao refeicao = this.cozinheiro.preparar( item );
		this.embalagemCopa( refeicao );
		this.atendente.revisa( refeicao );
		return refeicao;
	}
	
	public void embalagemCopa(Refeicao refeicao) {
		refeicao.embalagem = Embalagem.Copa;
	}
	
	interface Atendente {
		void revisa( Refeicao ref );
	}
	
	interface Cozinheiro {
		Refeicao preparar(ItemCardapio item);
	}
	
	class Cardapio {
		public List<Refeicao> refeicoes;
	}
	
	enum ItemCardapio {
		X_Egg(Pao, Hamburguer, Queijo, Verdura, Ovo),
		X_Egg_Bacon(X_Egg, Bacon);
		
		private ItemCardapio(Ingrediente ... ins) {
			this.ingredientes = Lists.newArrayList( ins );
		}
		private ItemCardapio(ItemCardapio padrao, Ingrediente ... ins) {
			this( ins );
			for (Ingrediente ingrediente : padrao.ingredientes) {
				this.ingredientes.add( ingrediente ); 				
			}
		}
		public List<Ingrediente> ingredientes;
	}
	
	enum Ingrediente {
		Pao, Hamburguer, Queijo, Verdura, Bacon, Ovo, Pimenta;
	}
	
}