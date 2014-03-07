package br.edu.curso.teste.experimentos.junit.rules;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.edu.curso.teste.experimentos.junit.rules.DigitalAssetManager.Messages;

public class RuleTestExcepction {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void throwsIllegalArgumentExceptionIfIconIsNull() throws InterruptedException {
		exception.expect(NullPointerException.class);
		exception.expectMessage( Messages.ICON_DOESN_EXIST );
		new DigitalAssetManager(null, null);
	}
	
}