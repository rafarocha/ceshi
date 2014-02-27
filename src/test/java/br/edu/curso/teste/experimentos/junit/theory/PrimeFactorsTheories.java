package br.edu.curso.teste.experimentos.junit.theory;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import java.math.BigInteger;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class PrimeFactorsTheories {

	@Theory
	public void factorsPassPrimalityTest(@AnyPositive int n) {
		for (int each : PrimeFactors.of(n)) {
			assertTrue( isPrime(each) );			
		}
	}
	
	@Theory
	public void factorsMultiplyToOriginal(@AnyPositive int n) {
		int product = 1;
		for (int each : PrimeFactors.of(n))
			product *= each;

		assertEquals(n, product);
	}

	@Theory
	public void factorizationsAreUnique(@AnyPositive int m, @AnyPositive int n) {
		assumeThat(m, not(equalTo(n)));

		assertThat( PrimeFactors.of(m), not(equalTo(PrimeFactors.of(n))) );
	}
	
	public static boolean isPrime(int n) {
	    for(int i = 2; i < n; i++) {
	        if(n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}