package br.edu.curso.teste.experimentos.junit.theory;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeThat;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class AccountTest {

	@DataPoint
	public static Account account1 = new Account(new BigDecimal("30"));
	@DataPoint
	public static Account account2 = new Account(new BigDecimal("3"));
	@DataPoint
	public static Account account3 = new Account(new BigDecimal("75"));
	@DataPoint
	public static Account account4 = new Account(new BigDecimal("90"));
	@DataPoint
	public static Account account5 = new Account(new BigDecimal("100"));
	
	@Theory
	public void testTransferringMoney(Account johnDoe, Account janeDoe, Account  opa) {
		BigDecimal big = new BigDecimal(50);
		
		assumeThat(johnDoe.getBalance(),
				Matchers.greaterThanOrEqualTo(big));
		
		BigDecimal balanceBefore = janeDoe.getBalance();
		assertTrue(johnDoe.transfer(big, janeDoe));
		System.out.println( balanceBefore + " \t "+ janeDoe.getBalance() );
		
		System.out.println( opa );
	}

	@Theory
	public void testWithdraw(Account account) {
		BigDecimal big = new BigDecimal(50);
		assumeThat(account.getBalance(), Matchers.greaterThan(big));
		assertTrue(account.withdraw(big));	
	}	
}