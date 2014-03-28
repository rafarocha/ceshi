package br.edu.curso.junit.exemplo.rules;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.edu.curso.junit.exemplo.rules.DigitalAssetManager.Messages;

public class RuleTestExcepction {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void throwsIllegalArgumentExceptionIfIconIsNull() throws InterruptedException {
		exception.expect(NullPointerException.class);
		exception.expectMessage( Messages.ICON_DOESN_EXIST );
		new DigitalAssetManager(null, null);
	}
	
	@Test @Ignore public void assertionErrorNotCatch() { // nao captura por que?
		exception.expect(AssertionError.class);
		throw new AssertionError();
	}
	
}