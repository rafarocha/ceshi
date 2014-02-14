package com.rocha.curso.ceshi.refactoring.pattern.templatemethod;

import static org.junit.Assert.assertEquals;

import java.util.Queue;

import net.vidageek.mirror.dsl.ClassController;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.class)
public class MaquinaTest {
	
	@Spy 
	private Maquina maquina;
	private ClassController<Maquina> controller; 
	
	@Before public void before() {
		this.controller = new Mirror().on(Maquina.class);
	}
	
	@Test public void testaAlgo() {
		String[] loggers = new String[]{ "rafa", "rocha" };
		for (String log : loggers) {
			maquina.log( log );	
		}		
		checarLog( loggers );
	}
	
	private void checarLog( String[] loggers ) {
		Queue<String> log = log();
		for (String expected : loggers) {
			assertEquals( expected, log.poll() );
		}
	}

	private Queue<String> log() {
		return (Queue<String>) controller.get().field("log");
	}
	
}