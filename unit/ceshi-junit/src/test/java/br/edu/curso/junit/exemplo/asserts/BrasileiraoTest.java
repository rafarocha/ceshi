package br.edu.curso.junit.exemplo.asserts;

import static br.edu.curso.junit.exemplo.asserts.BrasileiraoTest.BrasileiraoMatchers.containsOnly;
import static br.edu.curso.junit.exemplo.asserts.BrasileiraoTest.BrasileiraoMatchers.inOrder;
import static br.edu.curso.junit.exemplo.asserts.BrasileiraoTest.Clube.Cruzeiro;
import static br.edu.curso.junit.exemplo.asserts.BrasileiraoTest.Clube.Fluminense;
import static br.edu.curso.junit.exemplo.asserts.BrasileiraoTest.Clube.Internacional;
import static br.edu.curso.junit.exemplo.asserts.BrasileiraoTest.Clube.SaoPaulo;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class BrasileiraoTest {
	
	private Brasileirao brasileirao;
	private static int pontos = 60;
	
	@Before public void before() {
		pontos = 60; // TODO melhorar isto. usado só no enum
		this.brasileirao = new Brasileirao();
	}

	@Test public void classificados() {
		assertThat( "apenas os times em ordem que estão no G4 da Série A", 
				brasileirao.classificados( Serie.A ),
				containsOnly(
				    	time(Cruzeiro, 60),
				    	time(Internacional, 58),
				    	time(SaoPaulo, 59),
				    	time(Fluminense, 57)     
				 ));
	}
	
	@Test public void classificadosEmOrdem() {
		assertThat( "apenas os times em ordem que estão no G4 da Série A", 
				brasileirao.classificados( Serie.A ),
				containsOnly(
					inOrder(
				    	time(Cruzeiro, 60),
				    	time(SaoPaulo, 59),
				    	time(Internacional, 58),
				    	time(Fluminense, 57)     
				 )));
	}

	private Time time(Clube clube, Integer pontos) {
		return new Time(clube.name(), pontos);
	}
	
	// entity & target test
	class Brasileirao {
		public Map<Serie, List<Time>> resultado;
		public Brasileirao() {
			this.resultado = Maps.newHashMap();
			this.iniciar();
		}
		public List<Time> classificados(Serie serie) {
			List<Time> classificados = Lists.newArrayList();
			List<Time> times = resultado.get(serie);
			
			int posicao = 0;
			for (Time time : times) {
				if ( ++posicao <= 4 ) {
					classificados.add(time);
				}
			}
			return classificados;
		}
		private Brasileirao iniciar() {
			for (Clube clube : Clube.values()) {
				this.inscrever( clube.time() );
			}
			return this;
		}
		private void inscrever(Time time) {
			List<Time> times = resultado.get( Serie.A );
			if ( times == null ) times = Lists.newArrayList();
			times.add( time );
			resultado.put( Serie.A, times);
		}
	}
	
	// matchers
	static class BrasileiraoMatchers {
		public static Matcher<? super List<Time>> containsOnly(final BrasileiraoMatcher matcher) {
			return new TypeSafeDiagnosingMatcher<List<Time>>() {
				@Override public void describeTo(Description description) {
					description.appendText( matcher.mensagem );
				}
				@Override protected boolean matchesSafely(List<Time> times, Description mismatchDescription) {
					return matcher.matches( times );
				}
			};
		}
		public static BrasileiraoMatcher inOrder(final Time ... times) {
			return new InOrder().with( times );
		}
		public static BrasileiraoMatcher containsOnly(final Time ... times) {
			return new ContainsOnly().with( times );
		}
	}
	
	static abstract class BrasileiraoMatcher extends TypeSafeDiagnosingMatcher<List<Time>> {
		protected List<Time> esperados;
		protected String mensagem;
		
		public BrasileiraoMatcher with(Time ... times) {
			this.esperados = Lists.newArrayList(times);
			return this;
		}
		
		public void describeTo(Description desc) {
			desc.appendText( this.mensagem );
		}
		protected String message(Time esperado, Time obtido, int posicao) {
			String message = "deveria vir o time %s na posicao %d com %d pontos, mas, veio o time %s nesta posicao com %d pontos";
			return String.format(message, 
					esperado.nome, posicao, esperado.pontos,  
					obtido.nome, obtido.pontos);
		}
	}
	
	static class ContainsOnly extends BrasileiraoMatcher {
		String MSG_TAM_DIFF = "tamanho diverge, esperados %d";
		String MSG_TIME_ESP = "time esperado não classificado. esperado %s";
		@Override protected boolean matchesSafely(List<Time> times, Description mismatchDescription) {
			if ( times.size() != esperados.size() ) {
				this.mensagem = String.format( MSG_TAM_DIFF, esperados.size() );
				return false;
			}
			for (Time esperado : esperados) {
				if ( !times.contains(esperado) ) {
					this.mensagem = String.format( MSG_TAM_DIFF, esperado );
					return false;
				}
			}
			return true;
		}
	}
	
	static class InOrder extends BrasileiraoMatcher {
		private static final String MSG_FAIL_ORDER = 
				"deveria vir o time %s na posicao %d com %d pontos, "
				+ "mas, veio o time %s na posicao com %d pontos";
		@Override protected boolean matchesSafely(List<Time> times, Description desc) {
			int posicao = 0;
			for (Time esperado : times) {
				Time obtido = esperados.get(posicao++);
				if ( esperado.equals(obtido) ) {
					continue;
				}
				this.configureMessage(esperado, obtido, posicao);
				return false;
			}
			return true;
		}
		private void configureMessage(Time esperado, Time obtido, int posicao) {
			this.mensagem = String.format(
					MSG_FAIL_ORDER, 
					esperado.nome, posicao, esperado.pontos,  
						obtido.nome, obtido.pontos
				);
		}
	}
	
	// entities
	static class Time {
		String nome;
		Integer pontos;
		public Time(String nome, Integer pontos) {
			this.nome = nome;
			this.pontos = pontos;
		}
		@Override public boolean equals(Object obj) {
			if (obj == null || getClass() != obj.getClass() ) {
				return false;
			}
			final Time time = (Time) obj;		
			return 
				Objects.equal( this.nome, time.nome ) &&
				Objects.equal( this.pontos, time.pontos );
		}
		@Override public int hashCode() {
			return Objects.hashCode( this.nome, this.pontos );
		}
		@Override public String toString() {
			return this.nome + " com " + this.pontos + " pontos";
		}
	}
	
	enum Serie {
		A, B, C
	}
	
	enum Clube {
		Cruzeiro, SaoPaulo, Internacional, Fluminense, 
			AtleticoMG, Gremio, Corinthians, Santos,
				AtleticoPR, Flamengo, Goias, Sport,
					Palmeiras, Figueirense, Chapecoense, Vitoria,
						Coritiba, Botafogo, Bahia, Criciúma;
		public Time time() {
			return new Time( this.toString(), pontos-- );
		}
	}
}