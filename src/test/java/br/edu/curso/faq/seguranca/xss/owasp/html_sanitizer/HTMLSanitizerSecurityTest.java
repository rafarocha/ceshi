package br.edu.curso.faq.seguranca.xss.owasp.html_sanitizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class HTMLSanitizerSecurityTest {
	
	private HTMLSanitizerSecurity sanitizer;
	
	private interface HTML {
		String intruder =
	        "<textarea>Hello</textarea>,<b onclick=alert(42)>World</B>!"
	        + "<Script type=text/javascript>doEvil()</script><PLAINTEXT>";
		
		String friendly = "<strong>Hello</strong><ul><li>World</li></ul>";
	}
	
	private interface Expected {
		String intruderOutputExpected = "Hello,<b>World</b>!";
		String[] intruders = new String[] { "<textarea>", "<b onclick>", "<script>", "<plaintext>" };
	}
	
	@Before public void before() {
		this.sanitizer = HTMLSanitizerSecurity.create();
	}
	
	@Test public void doFilterConteudoMalicioso() {
		String output = sanitizer.apply( HTML.intruder );
		assertEquals( Expected.intruderOutputExpected, output );
		assertTrue( sanitizer.hasViolations() );
	}
	
	@Test public void doFilterConteudoSeguro() {
		String output = sanitizer.apply( HTML.friendly );
		assertEquals( HTML.friendly, output );
		assertFalse( sanitizer.hasViolations() );
	}
	
	@Test public void getInvasiveElements() {
		sanitizer.apply( HTML.intruder );
		List<String> elements = sanitizer.getInvasiveElements();
		// 4 elementos invasivos: textarea, b por conta do onclick, script e plaintext
		assertEquals( 4, elements.size() );
		
		Iterator<String> iterator = elements.iterator();
		for (String element : Expected.intruders) {
			assertEquals( element, iterator.next() );			
		}
	}
	
	@Test(expected=IllegalStateException.class) 
	public void getInvasiveElementsQuandoNaoRealizouNenhumPedidoFiltro() {
		sanitizer.getInvasiveElements();
	}
	
	@Test(expected=IllegalArgumentException.class) public void doFilterStringNula() {
		String nulo = null;
		sanitizer.apply( nulo );
	}
	
	@Test(expected=IllegalArgumentException.class) public void doFilterBinderNulo() {
		HTMLSanitizerBinder binder = null;
		sanitizer.apply( binder );
	}
	
	@Test(expected=IllegalArgumentException.class) public void doFilterBinderInputNulo() {
		HTMLSanitizerBinder binder = new HTMLSanitizerBinder() {
			protected void bind() {}
			protected void fill() {}			
		};
		sanitizer.apply( binder );
	}
	
	@Test public void doFilterBinderSucesso() {
		final List<String> arguments = new ArrayList<String>();
		HTMLSanitizerBinder binder = new HTMLSanitizerBinder() {
			protected void fill() {
				this.configure( HTML.intruder, HTML.friendly ); 
			}
			protected void bind() {
				arguments.add( this.next() );
				arguments.add( this.next() );
			}
		};
		sanitizer.apply( binder );
		
		// verificando comportamento do componente
		List<String> intruders = sanitizer.getInvasiveElements();
		assertTrue( sanitizer.hasViolations() );
		assertFalse( intruders.isEmpty() );
		assertEquals( intruders.size(), Expected.intruders.length ); 
		Iterator<String> iteIintruder = intruders.iterator();		
		for (String intruder : Expected.intruders) {
			assertEquals( iteIintruder.next(), intruder );
		}
		
		// verificando resultados esperadas		
		assertEquals( 2, arguments.size() );
		assertEquals( Expected.intruderOutputExpected, arguments.get(0));
		assertEquals( HTML.friendly, arguments.get(1));
	}
	
	@Test public void doFilterElementosConhecidosInclusiveObscuros() {		
		for (String friendlyElement : HTMLSanitizerSecurity.Attributes.allowElements) {
			sanitizer.apply( friendlyElement );
			assertFalse( sanitizer.hasViolations() );
		}
		
		String[] obscureElements = new String[] { "<kz>Bom dia</xy>", "<aiai>Opa</aiai>" };
		for (String friendlyElement : obscureElements) {
			sanitizer.apply( friendlyElement );
			assertTrue( sanitizer.hasViolations() );
		}		
	}
	
}