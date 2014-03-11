package br.edu.curso.teste.faq.metodo_privado;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MetodoPrivadoTest {
	
	@Test public void marinhaPilotaNavio() {
		Soldado soldado = new Soldado(ForcaArmada.Marinha);
		assertThat(soldado.transporte, is(Transporte.Navio));
	}
	
	@Test public void exercitoPilotaTanque() {
		Soldado soldado = new Soldado(ForcaArmada.Exercito);
		assertThat(soldado.transporte, is(Transporte.Tanque));
	}
	
	@Test public void aeronauticaPilotaNave() {
		Soldado soldado = new Soldado(ForcaArmada.Aeronautica);
		assertThat(soldado.transporte, is(Transporte.Nave));
	}
	
	class Soldado {
		
		private ForcaArmada forcaArmada;
		private Transporte transporte;		
		
		public Soldado(ForcaArmada forca) {
			this.forcaArmada = forca;
			this.transporte = transporte();
		}
		
		private Transporte transporte() {
			switch (forcaArmada) {
				case Exercito: return Transporte.Tanque;
				case Marinha: return Transporte.Navio;
				case Aeronautica: return Transporte.Nave;
			}
			throw new IllegalStateException();
		}
		
	}
	
	enum ForcaArmada {
		Exercito, Marinha, Aeronautica;
	}
	
	enum Transporte {
		Tanque, Navio, Nave;
	}
	
}