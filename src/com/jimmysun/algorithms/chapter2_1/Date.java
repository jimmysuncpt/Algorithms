package com.jimmysun.algorithms.chapter2_1;

import edu.princeton.cs.algs4.StdOut;

public class Date implements Comparable<Date> {
	private final int month;
	private final int day;
	private final int year;

	public Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
	}

	public int month() {
		return month;
	}

	public int day() {
		return day;
	}

	public int year() {
		return year;
	}

	@Override
	public String toString() {
		return month() + "/" + day() + "/" + year();
	}

	@Override
	public boolean equals(Object x) {
		if (this == x) {
			return true;
		}
		if (x == null) {
			return false;
		}
		if (this.getClass() != x.getClass()) {
			return false;
		}
		Date that = (Date) x;
		if (this.day != that.day) {
			return false;
		}
		if (this.month != that.month) {
			return false;
		}
		if (this.year != that.year) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Date that) {
		if (this.year > that.year) {
			return 1;
		}
		if (this.year < that.year) {
			return -1;
		}
		if (this.month > that.month) {
			return 1;
		}
		if (this.month < that.month) {
			return -1;
		}
		if (this.day > that.day) {
			return 1;
		}
		if (this.day < that.day) {
			return -1;
		}
		return 0;
	}

	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int d = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		Date date = new Date(m, d, y);
		StdOut.println(date);
	}
}
