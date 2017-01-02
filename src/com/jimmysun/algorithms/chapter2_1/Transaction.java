package com.jimmysun.algorithms.chapter2_1;

import java.util.Arrays;

public class Transaction implements Comparable<Transaction> {
	private String who; // customer
	private Date when; // date
	private double amount; // amount

	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}

	/**
	 * Exercise 1.2.19
	 * 
	 * @param transaction
	 */
	public Transaction(String transaction) {
		String[] fields = transaction.split("\\s+");
		who = fields[0];
		when = new Date(fields[1]);
		amount = Double.parseDouble(fields[2]);
	}

	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * Exercise 1.2.14
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		Transaction that = (Transaction) obj;
		if (!this.who.equals(that.who)) {
			return false;
		}
		if (!this.when.equals(that.when)) {
			return false;
		}
		if (this.amount != that.amount) {
			return false;
		}
		return true;
	}

	/**
	 * Exercise 2.1.21
	 */
	@Override
	public int compareTo(Transaction that) {
		if (this.amount > that.amount) {
			return 1;
		}
		if (this.amount < that.amount) {
			return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		Transaction[] transactions = new Transaction[] { new Transaction("Big", new Date(5, 22, 1939), 123.45),
				new Transaction("Medium", new Date(5, 22, 1939), 50.5),
				new Transaction("Small", new Date(5, 22, 1939), 11.99) };
		Arrays.sort(transactions);
		for (Transaction transaction : transactions) {
			System.out.println("Who: " + transaction.who + "\tAmount: " + transaction.amount);
		}
	}
}
