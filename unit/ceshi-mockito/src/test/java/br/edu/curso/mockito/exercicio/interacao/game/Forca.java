package br.edu.curso.mockito.exercicio.interacao.game;

import static br.edu.curso.mockito.exercicio.interacao.game.Mensagem.dica;
import static br.edu.curso.mockito.exercicio.interacao.game.Mensagem.looser;
import static br.edu.curso.mockito.exercicio.interacao.game.Mensagem.mostraErros;
import static br.edu.curso.mockito.exercicio.interacao.game.Mensagem.regra;
import static br.edu.curso.mockito.exercicio.interacao.game.Mensagem.welcome;
import static br.edu.curso.mockito.exercicio.interacao.game.Mensagem.winner;
import static br.edu.curso.mockito.exercicio.interacao.game.Mensagem.perigo;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.Builder;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import br.edu.curso.mockito.exercicio.interacao.game.Dicionario.Tema;

import com.google.common.collect.Lists;

@Builder
@Accessors(fluent = true)
@AllArgsConstructor(access=AccessLevel.PACKAGE)
public class Forca {

	private boolean gameover = false;
	private boolean acertou  = false;
	
	private String palavraSorteada;
	private int errosTolerados;
	private int tentativas;
	private int erros;

	private Dicionario dicionario;
	private Desenhista desenhista;
	private Coletor coletor;
	
	private char[] palavra;
	private List<String> chutes;
	private boolean errouUltimoChute;

	void inicia(Tema tema) {
		try {
			this.palavraSorteada = dicionario.eleger(tema);			
		} catch (AssertionError e) {
			throw new IllegalStateException("erro ao iniciar jogo", e);
		}
		this.palavra = this.montar();
		this.errosTolerados = 6;
		this.chutes = Lists.newArrayList();
		
		this.cabecalho( tema );
	}

	private void cabecalho(Tema tema) {
		this.boasVindas();
		this.imprime( regra );
		this.imprime( String.format(dica, tema, palavraSorteada.length()) );
		mostrar( null );
	}

	private boolean fimJogo() {
		return this.gameover || acertou || erros > errosTolerados;
	}

	public final void jogar(Tema tema) {
		inicia(tema);
		while (!fimJogo()) {
			realizarJogada();
		}
		resultado();
	}

	private void resultado() {
		if ( acertou ) {
			this.imprime( String.format(winner, palavraSorteada, tentativas) );
		} else {
			this.imprime( String.format(looser, this.palavraSorteada, tentativas ) );
		}
	}

	private void realizarJogada() {
		String chute = coletor.obter();
		tentativas++;
		
		if ( chute.length() == 1 ) {
			atualizarPalavra( chute );
			
			this.errouUltimoChute = !this.temLetra( chute );			
			if ( errouUltimoChute ) {
				desenhista.desenha( ++erros );
				chutes.add( chute );
			} else {
				acertou = palavraSorteada.equals( String.valueOf(palavra) ); 
			}
			mostrar( chute );				
		} else {
			acertou = chute.equals(palavraSorteada);
			gameover = !acertou;
		}

		if ( ultimaJogada() ) {
			this.imprime( perigo );
		}
	}
	
	private boolean ultimaJogada() {
		return erros == errosTolerados;
	}

	private static final Forca forca() {
		return Forca.builder()
					.dicionario( new Dicionario() )
					.desenhista( new Desenhista() )
					.coletor( new Coletor() )
					.build();
	}

	public static void main(String[] args) {
		forca().jogar( Tema.animais );
	}

	private void boasVindas() {
		for (String s : welcome) {
			this.imprime( s );
		}
	}
	
	private char[] montar() {
		char[] array = this.palavraSorteada.toCharArray();
		for (int i = 0; i < array.length; i++) {
			array[i] = '_';
		}
		return array;
	}
	
	private boolean temLetra(String chute) {
		return this.palavraSorteada.contains( chute );
	}
	
	private void atualizarPalavra(String letra) {
		char[] array = this.palavraSorteada.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if ( StringUtils.isEmpty( letra ) )
				break;
				
			if ( array[i] == letra.charAt(0) ) {
				palavra[i] = array[i];				
			}
		}
	}
	
	private void mostrar(String letra) {
		this.imprime( "\n" );
		for (char xar : palavra) {
			this.imprimeSln( xar + "\t" );
		}

		String letras = ArrayUtils.toString( chutes.toArray() );
		String textoAcerto = ( this.errouUltimoChute ) ? "poxa" : "isso";
		String msg = String.format( mostraErros, textoAcerto, chutes.size(), letras);
		if ( tentativas > 0 )
			this.imprime( msg );
	}
	
	private void imprime(String mensagem) {
		System.out.println( mensagem );
	}
	
	private void imprimeSln(String mensagem) {
		System.out.print( mensagem );
	}

}