package com.jimmysun.algorithms.chapter1_2;

public class Transaction {
	private String who; // customer
	private Date when; // date
	private double amount; // amount

	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
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
}
