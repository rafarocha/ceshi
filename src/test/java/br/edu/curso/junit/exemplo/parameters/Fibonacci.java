package br.edu.curso.junit.exemplo.parameters;

public class Fibonacci {

	public static int compute(int n) {
		if (n < 2) { 
			return n; 
		} else { 
			return compute(n - 1) + compute(n - 2); 
		}
	}
	
}