package com.jimmysun.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdIn;

public class Rational {
	private int numerator;
	private int denominator;

	public Rational(int numerator, int denominator) throws ArithmeticException {
		if (denominator == 0) {
			throw new ArithmeticException("Divide by zero");
		}
		int commonDivisor = euclid(numerator, denominator);
		this.numerator = numerator / commonDivisor;
		this.denominator = denominator / commonDivisor;
	}

	private int euclid(int p, int q) {
		if (p == 0 || q == 0) {
			return 1;
		}
		p = Math.abs(p);
		q = Math.abs(q);
		if (p < q) {
			int t = p;
			p = q;
			q = t;
		}
		if (p % q == 0) {
			return q;
		} else {
			return euclid(q, p % q);
		}
	}

	public Rational plus(Rational b) {
		return new Rational(numerator * b.denominator + b.numerator * denominator, denominator * b.denominator);
	}

	public Rational minus(Rational b) {
		return new Rational(numerator * b.denominator - b.numerator * denominator, denominator * b.denominator);
	}

	public Rational times(Rational b) {
		return new Rational(numerator * b.numerator, denominator * b.denominator);
	}

	public Rational divides(Rational b) {
		return new Rational(numerator * b.denominator, denominator * b.numerator);
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
		Rational that = (Rational) obj;
		if (this.numerator != that.numerator) {
			return false;
		}
		if (this.denominator != that.denominator) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		if (Math.abs(numerator) % Math.abs(denominator) == 0) {
			return String.valueOf(numerator / denominator);
		} else if (numerator * denominator > 0) {
			return Math.abs(numerator) + "/" + Math.abs(denominator);
		} else {
			return "-" + Math.abs(numerator) + "/" + Math.abs(denominator);
		}
	}

	public static void main(String[] args) {
		System.out.println("Rational a:");
		System.out.print("numerator: ");
		int numerator = StdIn.readInt();
		System.out.print("denominator: ");
		int denominator = StdIn.readInt();
		Rational a = new Rational(numerator, denominator);
		System.out.println("Rational b:");
		System.out.print("numerator: ");
		numerator = StdIn.readInt();
		System.out.print("denominator: ");
		denominator = StdIn.readInt();
		Rational b = new Rational(numerator, denominator);
		System.out.println("a plus b: " + a.plus(b));
		System.out.println("a minus b: " + a.minus(b));
		System.out.println("a times b: " + a.times(b));
		System.out.println("a divides b: " + a.divides(b));
		System.out.println("a equals b: " + a.equals(b));
	}
}
