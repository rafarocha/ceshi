package br.edu.curso.teste.refactoring.generictype;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;

public class People {
	
	public String name;
	public int age;
	
	class Product {
		public String name;
		public String id;
		public double price;

		public Product(String name, String id, double price) {
			super();
			this.name = name;
			this.id = id;
			this.price = price;
		}
	}
	
	static class Util {
		public static String getFile(String name) throws IOException {
			InputStream is = TransformerTest.class.getResourceAsStream(name);
			StringWriter writer = new StringWriter();
			IOUtils.copy(is, writer);
			return writer.toString();
		}
		public static String getName(Class<?> klazz) {
			return klazz.getSimpleName().toLowerCase(); 
		}
	}
	
	enum JSON {
		product, people, order;
		public String extract() throws IOException {
			return Util.getFile( this.toString().concat(".json") );
		}
		
	}

}