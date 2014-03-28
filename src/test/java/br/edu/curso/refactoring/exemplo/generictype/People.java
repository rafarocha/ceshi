package br.edu.curso.refactoring.exemplo.generictype;

import java.io.IOException;

import br.edu.curso.util.Util;

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
	
	enum JSON {
		product, people, order;
		public String extract() throws IOException {
			return Util.carregarArquivo( People.class, this.toString().concat(".json") );
		}
		
	}

}