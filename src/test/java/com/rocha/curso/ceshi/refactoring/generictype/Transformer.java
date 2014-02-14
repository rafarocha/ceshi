package com.rocha.curso.ceshi.refactoring.generictype;

import com.rocha.curso.ceshi.refactoring.generictype.People.Product;
import com.rocha.curso.ceshi.refactoring.generictype.People.Util;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

/**
 * Implemente o método <code>toOrder()</code> efetuando as refatorações necessárias 
 * 
 * <ul>
 * <li>Não utilize condição if/else</li>
 * <li>Para se certificar de que tudo esteja funcionando rode <code>TransformerTest</code></li>
 * </ul>  
 * 
 * Este exercício tem uma pegadinha :) <br>
 * http://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html
 */
public class Transformer {
	
	public Product toProduct(String json) {
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias(Util.getName(Product.class), Product.class);
		return (Product) xstream.fromXML( json );
	}
	
	public People toPeople(String json) {
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		xstream.setMode(XStream.NO_REFERENCES);
		xstream.alias( Util.getName(People.class), People.class);
		return (People) xstream.fromXML( json );
	}

	public Order toOrder(String json) {
		return null;
	}
	
}