package br.edu.curso.dubles.dummy.exemplo.jetsons;

import org.apache.commons.lang.NotImplementedException;

public class Dog {
	
	public String name;
	public Object leash;
	
	public Dog(String name) {
		this.name = name;
	}

	public void use(Object coleira) {
		throw new NotImplementedException();
	}
	
	public Local getLocalPreferidoPasseio() {
		return new Local(23,45,67);
	}

}