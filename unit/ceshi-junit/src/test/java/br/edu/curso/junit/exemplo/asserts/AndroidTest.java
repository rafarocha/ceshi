package br.edu.curso.junit.exemplo.asserts;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class AndroidTest {
	
	@Test public void equalsSerieDiferente() {
		Android androidA = this.cria("404", "2014", "001"); 
		Android androidB = this.cria("202", "2014", "001");
		assertNotEquals( androidA, androidB );
	}

	@Test public void equalsAnoDiferente() {
		// assertTrue
	}
	
	private Android cria(String serie, String ano, String lote) {
		return Android.builder()
					.serie( serie )
					.ano( ano )
					.lote( lote )
				.build();
	}

}