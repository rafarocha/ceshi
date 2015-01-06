package br.edu.curso.mockito.exercicio.stubbing.game;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

public class Jogador implements Comparable<Jogador> {
	
	public String nome;
	public String endereco;
	public Configuracao configuracao;
	
	public List<Posicao> acertos;
	
	private ValidadorJogador validadorJogador;
	private ValidadorPalpites validadorPalpites;
	private ValidadorConfiguracao validadorConfiguracao;
	
	public Jogador(String nome, String endereco, Configuracao configuracao) {
		this(nome, endereco);
		
		this.configuracao = configuracao;
		this.configuracao.configurar();
		this.validar();
	}
	
	private Jogador(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
		this.acertos = Lists.newArrayList();
		
		this.validadorJogador = new ValidadorJogador();
		this.validadorPalpites = new ValidadorPalpites();
		this.validadorConfiguracao = new ValidadorConfiguracao();
	}
	
	@Override public String toString() {
		return this.nome;
	}

	public String toStringCompleto() {
		StringBuilder builder = new StringBuilder();
		builder.append( "nome \t\t %s \n" );
		builder.append( "palpites \t %s \n" );
		builder.append( "configuracao \t %s \n" );
		builder.append( "acertos \t %s = %s \n" );
		return String.format( builder.toString(), this.nome, 
				this.toString( this.configuracao.palpites ), this.toString( this.configuracao.navios ), 
				this.toString( this.acertos ), this.acertos.size() );
	}
	
	private String toString(List<?> list) {
		return ArrayUtils.toString( list.toArray() );
	}
	
	public Integer total() {
		return this.acertos.size();
	}
	
	public int compareTo(Jogador player) {
		return this.total().compareTo( player.total() );
	}
	
	private void validar() {
		validarCampos( this );			
		validarConfiguracao( this.configuracao.navios );
		validarPalpites( this.configuracao.palpites );				
	}
	
	private void validarCampos(Jogador jogador) {
		boolean valido = validadorJogador.matches( jogador );
		lancarExcecao(valido, "jogador sem nome, configuração ou palpites");
	}

	private void validarConfiguracao(List<Navio> configuracao) {
		boolean valido = validadorConfiguracao.matches( configuracao );
		lancarExcecao(valido, "configuração inválida");
	}

	private void validarPalpites(List<Posicao> palpites) {
		boolean valido = validadorPalpites.matches( palpites );
		lancarExcecao(valido, "palpites inválidos");
	}
	
	private void lancarExcecao(boolean condicao, String mensagem) {
		if ( !condicao ) {
			throw new IllegalStateException( mensagem );
		}
	}
	
	@Override public boolean equals(Object obj) {
		if (obj == null || getClass() != obj.getClass() ) {
			return false;
		}
		final Jogador jogador = (Jogador) obj;		
		return Objects.equal( this.nome, jogador.nome );
	}
	
}