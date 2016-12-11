package com.jimmysun.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdIn;

public class Ex18 {
	private double m;
	private double s;
	private int N;
	
	public void addDataValue(double x) {
		N++;
		s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
		m = m + (x - m) / N;
	}
	
	public double mean() {
		return m;
	}
	
	public double var() {
		return s / (N - 1);
	}
	
	public double stddev() {
		return Math.sqrt(this.var());
	}
	
	public static void main(String[] args) {
		Ex18 accumulator = new Ex18();
		while(!StdIn.isEmpty()) {
			accumulator.addDataValue(StdIn.readDouble());
		}
		System.out.println("Mean: " + accumulator.mean());
		System.out.println("Var: " + accumulator.var());
		System.out.println("Stddev: " + accumulator.stddev());
	}
}
