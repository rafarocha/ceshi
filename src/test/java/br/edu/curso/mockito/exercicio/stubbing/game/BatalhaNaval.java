package br.edu.curso.mockito.exercicio.stubbing.game;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class BatalhaNaval {
	
	interface Regras {
		int tamanho = 3;
		int maxNavios = 3;
		String[] colunasPermitidas = new String[] {
				"a", "b", "c"
			};
		int palpitesPermitidos = colunasPermitidas.length;
	}
	
	public enum Nivel {
		Basico(1), Intermediario(3), Insano(5);
		private Nivel(int nivel) {
			this.peso = nivel;
		}
		public int peso;
	}
	
	private Servidor servidor;
	private Jogador vencedor;
	
	public void jogar(Jogador j1, Jogador j2) {
		this.servidor.iniciarConexao();
		this.contarPontos( j1, j2 );
		this.contarPontos( j2, j1 );
		this.mostrarJogo ( j1, j2 );
		this.descobrirVencedor(j1, j2);
	}
	
	public Jogador anunciarVencedor() {
		String nome = ( vencedor == null ) ? "Empate" : vencedor.nome;
		System.out.println( "\nVencedor é .... " + nome + "\n\n");
		return vencedor;
	}

	private void descobrirVencedor(Jogador j1, Jogador j2) {
		int balanca = j1.compareTo(j2);
		switch ( balanca ) {
			case -1: {
				this.vencedor = j2;
				break;
			}
			case 1: {
				this.vencedor = j1;
				break;
			}
		}
	}

	private void contarPontos(Jogador player1, Jogador player2) {
		for (Navio navio : player1.configuracao.navios) {
			navio.contarAcertos( player2 );
		}
	}
	
	public void mostrarJogo(Jogador j1, Jogador j2) {
		System.out.println( j1.toStringCompleto() );
		System.out.println( j2.toStringCompleto() );
	}
	
	@SuppressWarnings("static-access")
	public BatalhaNavalBuilder but() {
		return BatalhaNaval.this.builder().servidor( this.servidor );
	}
	
	public static void main(String[] args) {
		
		// nome	+ posicao dos navios + palpites
		Jogador voce  = Oficina.jogador("Você", "a2:b3", "a2-a1-a3" );
		Computador computador = new Computador("E.T.", "", new Configuracao() {
			public void configurar() {
				this.configurar( this.criaConfiguracaoPropria() );
				this.palpitar( this.criaPalpitesProprios(Nivel.Basico) );
			}
		});
		
		BatalhaNaval batalha = BatalhaNaval.builder().servidor( new Servidor() ).build();
		batalha.jogar( voce, computador );
		batalha.anunciarVencedor();
		
	}
	
}