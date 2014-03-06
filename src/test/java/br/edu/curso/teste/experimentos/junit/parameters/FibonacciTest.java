package br.edu.curso.teste.experimentos.junit.parameters;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciTest {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
					{ 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, 
					{ 4, 3 }, { 5, 5 }, { 6, 8 }, { 7, 13 }
				}
			);
	}

	private int fInput;
	private int fExpected;

	public FibonacciTest(int input, int expected) {
		fInput = input;
		fExpected = expected;
	}

	@Test
	public void allValues() {
		int result = Fibonacci.compute(fInput);
		assertEquals(fExpected, Fibonacci.compute(fInput));
		
		String message = "%d \t %d \t\t %d";
		System.out.println( String.format(message, fInput, result, fExpected) );
	}
	
	@BeforeClass
	public static void beforeAll() {
		System.out.println( "fibonacci test\n" );
		System.out.println( "index \t expected \t result" );
	}
	
}