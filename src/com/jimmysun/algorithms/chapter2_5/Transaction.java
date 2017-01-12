package com.jimmysun.algorithms.chapter2_5;

import java.util.Comparator;

import com.jimmysun.algorithms.chapter2_1.Date;

public class Transaction {
	private final String who; // customer
	private final Date when; // date
	private final double amount; // amount

	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}

	public String getWho() {
		return who;
	}

	public Date getWhen() {
		return when;
	}

	public double getAmount() {
		return amount;
	}

	public static class WhoOrder implements Comparator<Transaction> {
		@Override
		public int compare(Transaction v, Transaction w) {
			return v.who.compareTo(w.who);
		}
	}

	public static class WhenOrder implements Comparator<Transaction> {
		@Override
		public int compare(Transaction v, Transaction w) {
			return v.when.compareTo(w.when);
		}
	}

	public static class HowMuchOrder implements Comparator<Transaction> {
		@Override
		public int compare(Transaction v, Transaction w) {
			if (v.amount < w.amount) {
				return -1;
			}
			if (v.amount > w.amount) {
				return 1;
			}
			return 0;
		}
	}
}
