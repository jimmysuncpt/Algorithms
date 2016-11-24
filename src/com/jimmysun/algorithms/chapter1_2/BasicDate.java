package com.jimmysun.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdOut;

public class BasicDate {
	private final int month;
	private final int day;
	private final int year;

	public BasicDate(int m, int d, int y) {
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
	
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int d = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		BasicDate date = new BasicDate(m, d, y);
		StdOut.println(date);
	}
}
