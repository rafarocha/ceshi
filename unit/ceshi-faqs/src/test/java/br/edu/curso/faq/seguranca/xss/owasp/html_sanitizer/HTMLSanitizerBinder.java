package br.edu.curso.faq.seguranca.xss.owasp.html_sanitizer;

import java.util.Iterator;
import java.util.List;

public abstract class HTMLSanitizerBinder {
	
	protected String[] in;
	protected Iterator<String> out;
	
	public HTMLSanitizerBinder() {
		fill();
	}
	
	protected String next() {
		if ( out.hasNext() ) {
			return out.next();				
		}
		return null;
	}
	protected abstract void fill(); // setar� informa��es a filtrar
	protected abstract void bind(); // setar� de volta no bean informa��es filtradas
	protected HTMLSanitizerBinder set(List<String> out) {
		this.out = out.iterator();
		return this;
	}	
	protected void configure(String ... arguments) {
		this.in = arguments;
	}

}