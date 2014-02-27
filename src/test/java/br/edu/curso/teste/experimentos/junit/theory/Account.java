package br.edu.curso.teste.experimentos.junit.theory;

import java.math.BigDecimal;

public class Account {

	private BigDecimal balance = BigDecimal.ZERO;
	private long id;
	
	private static int generator = 0;

	public Account(BigDecimal balance) {
		this.balance = balance;
		this.id = ++generator;
	}

	public Boolean withdraw(BigDecimal amount) {
		if (!hasEnoughBalance(amount)) {
			return false;
		}

		balance = balance.subtract(amount);
		return true;
	}

	public void deposit(BigDecimal amount) {
		balance = balance.add(amount);
	}

	public Boolean transfer(BigDecimal amount, Account toAccount) {
		if (!hasEnoughBalance(amount)) {
			return false;
		}

		balance = balance.subtract(amount);
		toAccount.deposit(amount);
		return true;
	}

	private Boolean hasEnoughBalance(BigDecimal amount) {
		return balance.compareTo(amount) >= 0;

	}

	public BigDecimal getBalance() {
		return this.balance;
	}
	
	public long getId() {
		return id;
	}
	
	@Override public String toString() {
		return "[" + this.id + "]" + this.balance;
	}

}