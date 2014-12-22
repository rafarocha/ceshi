package br.edu.curso.junit.exemplo.parameters;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FibonacciBetterTest {

	// n�o funciona string abaixo com parenteses
	@Parameters(name = "{index}: fib<{0}> = {1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] {
					{ 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, 
					{ 4, 3 }, { 5, 5 }, { 6, 8 }, { 7, 13 }
				}
			);
	}

	/* NOT private */
	@Parameter public int fInput; // first data value (0) is default
    @Parameter(value = 1) public int fExpected;

	@Test
	public void all() {
		int result = Fibonacci.compute(fInput);
		assertEquals(fExpected, Fibonacci.compute(fInput));
		
		String message = "%d \t %d \t\t %d";
		System.out.println( String.format(message, fInput, result, fExpected) );
	}
	
	@BeforeClass
	public static void beforeAll() {
		System.out.println( "fibonacci test" );
		System.out.println( "index \t expected \t result" );
	}
	
}