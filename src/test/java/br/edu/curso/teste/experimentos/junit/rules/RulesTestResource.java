package br.edu.curso.teste.experimentos.junit.rules;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class RulesTestResource {

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();

	private File icon;
	private File assets;
	
	@Test
	public void countsAssets() throws IOException {
		DigitalAssetManager dam = new DigitalAssetManager(icon, assets);
		dam.createAssets(3);
		assertEquals(3, dam.getAssetCount());
	}
	
	@Before public void before() throws IOException {
		this.icon = this.tempFolder.newFile(filename); 		// cria um arquivo em diretorio criado randomicamente
		this.assets = this.tempFolder.newFolder("assets"); 	// cria um diretorio em diretorio criado randomicamente
		
		checkFile();
	}
	
	private void checkFile() {
		assertTrue( "arquivo deve existir", icon.exists() );
		System.out.println( "entrada \t ".concat( icon.getPath() ) );
		
		Pattern pattern = getPattern(filename);
		assertTrue( pattern.matcher( icon.getPath() ).matches() ); 
	}
	
	private Pattern getPattern(String filename) {
		String expression = String.format(EXP_REG_TEMP_FILE, filename);
		System.out.println( "expressao \t ".concat( expression ) );
		return Pattern.compile( expression );
	}

	/**
	 * para testar expressão 
	 * http://tools.lymas.com.br/regexp_br.php#
	 * expressao	^(/tmp/)?[a-zA-Z0-9-\.]+(/icon.png)
	 * texto		/tmp/junit7256500214330795186/icon.png
	 */
	private static final String EXP_REG_TEMP_FILE = "^(/tmp/)?[a-zA-Z0-9-\\.]+(/%s)";
	private static final String filename = "icon.png";
	
}