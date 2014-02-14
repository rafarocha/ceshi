package com.rocha.curso.ceshi.refactoring.design_oo;

import junitx.util.PrivateAccessor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.rocha.curso.ceshi.refactoring.design_oo.CopyOfComando.Chave;
import com.rocha.curso.ceshi.refactoring.design_oo.CopyOfComando.ServicoA;
import com.rocha.curso.ceshi.refactoring.design_oo.CopyOfComando.ServicoB;

@RunWith(MockitoJUnitRunner.class)
public class ComandoTest {
	
	@Mock private ServicoA servicoA;
	@Mock private ServicoB servicoB;
	
	private CopyOfComando comando;
	
	@Before public void before() throws NoSuchFieldException {
		this.comando = new CopyOfComando();
		PrivateAccessor.setField(comando, "servicoA", this.servicoA);
		PrivateAccessor.setField(comando, "servicoB", this.servicoB);
		this.comando.configure();
	}

	@Test public void acaoXH() {
		comando.go( Chave.ALFA );
		Mockito.verify( servicoA ).acaoX();
		Mockito.verify( servicoB ).acaoH();
	}
	
	@Test public void acaoYI() {
		comando.go( Chave.DELTA );
		Mockito.verify( servicoA ).acaoY();
		Mockito.verify( servicoB ).acaoI();
	}
	
	@Test public void acaoZJ() {
		comando.go( Chave.GAMA );
		Mockito.verify( servicoA ).acaoZ();
		Mockito.verify( servicoB ).acaoJ();
	}
	
	@Test public void acaoNenhuma() {
		comando.go( null );
		Mockito.verifyZeroInteractions( servicoA, servicoB );
	}
	
}