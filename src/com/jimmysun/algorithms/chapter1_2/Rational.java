package com.jimmysun.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdIn;

public class Rational {
	private int numerator;
	private int denominator;

	public Rational(int numerator, int denominator) throws ArithmeticException {
		if (denominator == 0) {
			throw new ArithmeticException("Divide by zero");
		}
		if (denominator < 0) {
			numerator = -numerator;
			denominator = -denominator;
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
		assert !isTimesOverflow(numerator, b.denominator) : "Times overflow";
		assert !isTimesOverflow(b.numerator, denominator) : "Times overflow";
		assert !isPlusOverflow(numerator * b.denominator, b.numerator * denominator) : "Plus overflow";
		assert !isTimesOverflow(denominator, b.denominator) : "Times overflow";
		return new Rational(numerator * b.denominator + b.numerator * denominator, denominator * b.denominator);
	}

	public Rational minus(Rational b) {
		assert !isTimesOverflow(numerator, b.denominator) : "Times overflow";
		assert !isTimesOverflow(b.numerator, denominator) : "Times overflow";
		assert !isPlusOverflow(numerator * b.denominator, -b.numerator * denominator) : "Plus overflow";
		assert !isTimesOverflow(denominator, b.denominator) : "Times overflow";
		return new Rational(numerator * b.denominator - b.numerator * denominator, denominator * b.denominator);
	}

	public Rational times(Rational b) {
		assert !isTimesOverflow(numerator, b.numerator) : "Times overflow";
		assert !isTimesOverflow(denominator, b.denominator) : "Times overflow";
		return new Rational(numerator * b.numerator, denominator * b.denominator);
	}

	public Rational divides(Rational b) {
		assert !isTimesOverflow(numerator, b.denominator) : "Times overflow";
		assert !isTimesOverflow(denominator, b.numerator) : "Times overflow";
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
		} else {
			return numerator + "/" + denominator;
		}
	}

	private boolean isPlusOverflow(int a, int b) {
		return a >= 0 ? b > Integer.MAX_VALUE - a : b < Integer.MIN_VALUE - a;
	}

	private boolean isTimesOverflow(int a, int b) {
		if (a < 0) {
			a = -a;
		}
		if (b < 0) {
			b = -b;
		}
		if (a == 0 || b == 0) {
			return false;
		} else {
			return a * b / b != a;
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
