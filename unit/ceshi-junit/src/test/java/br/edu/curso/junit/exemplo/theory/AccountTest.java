package br.edu.curso.junit.exemplo.theory;

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
	
	private static int count = 0;
	
	@Theory
	public void testTransferringMoney(Account johnDoe, Account janeDoe) {
		BigDecimal big = new BigDecimal(50);
		
		// descobrir bug da mesma inst�ncia
//		System.out.println( "\t\t" + johnDoe.getBalance() );
		assumeThat(johnDoe.getBalance(), Matchers.greaterThanOrEqualTo(big));
		
		printf("#testcase"+  ++count, johnDoe, janeDoe);
		assertTrue(johnDoe.transfer(big, janeDoe));
		printf("\t", johnDoe, janeDoe);
	}	

	@Theory
	public void testWithdraw(Account account) {
		BigDecimal big = new BigDecimal(50);
		assumeThat(account.getBalance(), Matchers.greaterThan(big));
		assertTrue(account.withdraw(big));	
	}
	
	private void printf(String action, Account johnDoe, Account janeDoe) {
		System.out.printf(action + "  \t(john, jane) : (%s, %s)\n", 
				johnDoe.getBalance(), janeDoe.getBalance());
	}
	
}