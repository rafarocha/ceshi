package br.edu.curso.faq.seguranca.xss.owasp.html_sanitizer;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.owasp.html.Handler;
import org.owasp.html.HtmlChangeListener;
import org.owasp.html.HtmlChangeReporter;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.HtmlSanitizer;
import org.owasp.html.HtmlSanitizer.Policy;
import org.owasp.html.HtmlStreamEventReceiver;
import org.owasp.html.HtmlStreamRenderer;

import com.google.common.base.Function;

public class HTMLSanitizerSecurity {
	
	private HTMLSanitizerSecurity() {
		configure();
	}
	
	// opaque test value compared via equality (fake context)
	static class Context {}
	
	private interface MESSAGES {
		String hasBeenNotProcessed = 
			"Sanitizer ainda n�o efetuou nenhum filtro. � necess�rio chamar m�todo filter antes!";
	}
	
	private interface TAG {
		String GT = ">";
		String LT = "<";
		String SPACE = " ";
	}
	
	/**
	 * elementos permitidos pelo richtext editor 
	 */
	protected interface Attributes {
		String TAG_ALIGN = "align";
		String TAG_P = "p";
		
		String[] allowElements = new String[] {
			"p", "strong", "br", "ul", "ol", "li", "b", "em"
		};
		
		String[] allowElementsMatchesTagP = new String[] {
			"center", "left", "right", "justify"
		};		
	}
	
	public static final Function<HtmlStreamEventReceiver, HtmlSanitizer.Policy> 
				POLICY_DEFINITION = new HtmlPolicyBuilder()
		// The align attribute on <p> elements can have any value below.
		.allowAttributes( Attributes.TAG_ALIGN )
			.matching( true, Attributes.allowElementsMatchesTagP )
			.onElements( Attributes.TAG_P )
		// These elements are allowed.
		.allowElements( Attributes.allowElements )
		// Custom slashdot tags.
		.toFactory();
	
	private StringBuilder builder;
	private List<String> output;
	private List<String> invasiveElements;
	
	private HtmlStreamRenderer renderer;
	private HtmlChangeListener<Context> listener;
	private HtmlChangeReporter<Context> reporter;
	
	private boolean hasFilter;	 
	
	private void configure() {
		this.output = new ArrayList<String>();		
		this.invasiveElements = new ArrayList<String>();
		configureNewReporter();
	}

	private void configureNewReporter() {
		this.builder = new StringBuilder();
		this.listener = getHtmlChangeListener();
		this.renderer = HtmlStreamRenderer.create( builder, Handler.DO_NOTHING );
		this.reporter = new HtmlChangeReporter<Context>(renderer, listener, new Context());
		configurePolicy();
	}
	
	public static HTMLSanitizerSecurity create() {
		return new HTMLSanitizerSecurity();
	}

	private HtmlChangeListener<Context> getHtmlChangeListener() {
		return new HtmlChangeListener<Context>() {
			public void discardedTag(Context context, String elementName) {
				String element = this.withTag( elementName );
				invasiveElements.add( element );
			}
			public void discardedAttributes(Context context, String elementName, 
					String... attributeNames) {
				String element = this.withTag( elementName, attributeNames );
				invasiveElements.add( element );
			}
			private String withTag( String elementName, String ... attributeNames  ) {
				String initialName = TAG.LT.concat( elementName );
				if ( ArrayUtils.isEmpty( attributeNames ) ) {
					return initialName.concat( TAG.GT );					
				}
				
				String names = initialName;
				for (String attribute : attributeNames) {
					names = names.concat( TAG.SPACE.concat(attribute) );
				}
				return names.concat( TAG.GT );
			}
		};
	}
	
	/*
	 * output � setado via HtmlStreamRenderer no m�todo configure
	 */
	public String apply(String html) {
		this.filter( html );
		return this.output.get(0);
	}
	
	public void apply(HTMLSanitizerBinder binder) {
		this.filter( binder );
		binder.set( this.output ).bind();
	}
	
	private void filter(HTMLSanitizerBinder binder) {
		if ( binder == null ) {
			throw new IllegalArgumentException();
		}
		this.filter( binder.in );
	}

	private void filter(String ... htmls) {
		validate(htmls);
		
		for (String html : htmls) {
			HtmlSanitizer.sanitize( html, reporter.getWrappedPolicy() );
			output.add( builder.toString() );
			configureNewReporter();
		}
		
		this.hasFilter = true;
	}

	private void validate(String... htmls) {
		if ( ArrayUtils.isEmpty( htmls ) ) {
			throw new IllegalArgumentException("array htmls vazio ou nulo");
		}		
		for (String html : htmls) {
			if ( html == null ) {
				throw new IllegalArgumentException();
			}
		}
	}

	private void configurePolicy() {
		Policy policy = POLICY_DEFINITION.apply( this.reporter.getWrappedRenderer() );
		this.reporter.setPolicy( policy );
	}
	
	public List<String> getInvasiveElements() {
		validate();
		return this.invasiveElements;
	}
	
	public boolean hasViolations() {
		validate();
		return CollectionUtils.isNotEmpty( this.invasiveElements );
	}

	private void validate() {
		if ( !hasFilter ) {
			throw new IllegalStateException( MESSAGES.hasBeenNotProcessed );
		}
	}
	
	public String getInvasiveElementsToString() {
		validate();
		StringBuilder builder = new StringBuilder();
		for (String item : this.output) {
			builder.append( item + TAG.SPACE );
		}
		return builder.toString();
	}

}