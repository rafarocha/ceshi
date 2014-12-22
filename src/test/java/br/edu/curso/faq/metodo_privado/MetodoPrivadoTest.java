package br.edu.curso.faq.metodo_privado;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class MetodoPrivadoTest {
	
	@Test public void marinhaPilotaNavio() {
		Soldado soldado = new SoldadoMarinha();
		assertThat(soldado.transporte, is(Transporte.Navio));
	}
	
	@Test public void exercitoPilotaTanque() {
		Soldado soldado = new SoldadoExercito();
		assertThat(soldado.transporte, is(Transporte.Tanque));
	}
	
	@Test public void aeronauticaPilotaNave() {
		Soldado soldado = new SoldadoAeronautica();
		assertThat(soldado.transporte, is(Transporte.Nave));
	}
	
	abstract class Soldado {
		
		private ForcaArmada forcaArmada;
		private Transporte transporte;		
		
		private Transporte configure() {
			switch (forcaArmada) {
				case Exercito: return Transporte.Tanque;
				case Marinha: return Transporte.Navio;
				case Aeronautica: return Transporte.Nave;
			}
			throw new IllegalStateException();
		}
		
	}
	
	class SoldadoMarinha extends Soldado {
		public SoldadoMarinha() {
			super.forcaArmada = ForcaArmada.Marinha;
			super.transporte = super.configure();
		}
	}
	
	class SoldadoExercito extends Soldado {
		public SoldadoExercito() {
			super.forcaArmada = ForcaArmada.Exercito;
			super.transporte = super.configure();
		}
	}

	class SoldadoAeronautica extends Soldado {
		public SoldadoAeronautica() {
			super.forcaArmada = ForcaArmada.Aeronautica;
			super.transporte = super.configure();
		}
	}
	
	enum ForcaArmada {
		Exercito, Marinha, Aeronautica;
	}
	
	enum Transporte {
		Tanque, Navio, Nave;
	}
	
}