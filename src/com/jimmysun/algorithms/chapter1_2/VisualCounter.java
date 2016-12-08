package com.jimmysun.algorithms.chapter1_2;

import edu.princeton.cs.algs4.StdDraw;

public class VisualCounter {
	private int count;
	private int n;
	private int N;
	private int max;

	public VisualCounter(int n, int max) {
		N = n;
		this.max = max;
		count = 0;
		this.n = 0;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(-max, max);
		StdDraw.setPenRadius(0.01);
		StdDraw.point(0, 0);
	}

	public void increment() {
		if (n + 1 > N) {
			System.out.println("Operate too much!");
			return;
		}
		if (count + 1 > max) {
			System.out.println("Exceed the max!");
			return;
		}
		count++;
		n++;
		StdDraw.point(n, count);
	}

	public void decrement() {
		if (n + 1 > N) {
			System.out.println("Operate too much!");
			return;
		}
		if (count - 1 < -max) {
			System.out.println("Exceed the min!");
			return;
		}
		count--;
		n++;
		StdDraw.point(n, count);
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		VisualCounter counter = new VisualCounter(20, 5);
		for (int i = 0; i < 10; i++) {
			counter.increment();
		}
		for (int i = 0; i < 15; i++) {
			counter.decrement();
		}
		for (int i = 0; i < 10; i++) {
			counter.increment();
		}
		System.out.println(counter.getCount());
	}
}
