package br.edu.curso.java.exemplo.matcher;

import static br.edu.curso.java.exemplo.matcher.MatcherTest.Padrao.NOME_USUARIO;
import static br.edu.curso.java.exemplo.matcher.MatcherTest.Padrao.NUMEROS_APENAS;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @see 10 Java Regular Expression Examples You Should Know
 * {@link http://goo.gl/hDpA3C}
 */
public class MatcherTest {

	@Test public void numeroValido() {
		Pattern pattern = Pattern.compile( NUMEROS_APENAS );
		Matcher matcher = pattern.matcher( number() );
		assertTrue( matcher.matches() );
	}
	
	@Test public void numeroInvalido() {
		Pattern pattern = Pattern.compile( NUMEROS_APENAS );
		assertFalse( pattern.matcher( "9823m23" ).matches() );
	}
	
	@Test public void nomeUsuarioValido() {
		Pattern pattern = Pattern.compile( NOME_USUARIO );
		assertTrue( pattern.matcher( "rafarocha123" ).matches() );
	}
	
	@Test public void nomeUsuarioInvalido() {
		String[] invalidos = new String[] {
				"rafarocha1234567", "ab", "billgate$", 
				"", " ", "rafa rocha", "01234567890O"
		};
		Pattern pattern = Pattern.compile( NOME_USUARIO );
		for (String string : invalidos) {
			assertFalse( pattern.matcher( string ).matches() );			
		}
	}
	
	private static Random random = new Random();
	private String number() {
		Long number = Math.abs( random.nextLong() );
		return number.toString();
	}
	
	interface Padrao {
		String NUMEROS_APENAS = "[0-9]*";
		String NOME_USUARIO = "^[a-z0-9_-]{3,15}";
	}

}