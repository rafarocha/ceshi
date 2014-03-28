package br.edu.curso.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

public class UtilTest {	
	
	@Test public void getFileMesmoPacote() throws IOException {
		final String esperado = "texto de exemplo 123";
		String conteudo = Util.carregarArquivo( Util.class, "arquivo.txt");
		assertThat( conteudo, is( esperado ) );
	}

}