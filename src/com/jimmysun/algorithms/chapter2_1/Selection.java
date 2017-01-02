package com.jimmysun.algorithms.chapter2_1;

import java.awt.Color;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Selection {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}

	/**
	 * Exercise 2.1.18
	 * 
	 * @param a
	 */
	public static void drawSort(Comparable[] a) {
		int N = a.length;
		StdDraw.setYscale(N + 4, 0);
		StdDraw.setXscale(0, N + 3);
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.text(3 + N / 2, 0.4, "a[ ]");
		StdDraw.textRight(1, 1, "i");
		StdDraw.textRight(2, 1, "min");
		for (int i = 0; i < N; i++) {
			StdDraw.text(3 + i, 1, i + "");
			StdDraw.text(3 + i, 2, a[i].toString());
		}
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			StdDraw.textRight(1, 3 + i, i + "");
			StdDraw.textRight(2, 3 + i, min + "");
			StdDraw.setPenColor(Color.GRAY);
			for (int j = 0; j < N; j++) {
				if (j == i) {
					StdDraw.setPenColor(Color.BLACK);
				}
				if (j == min) {
					StdDraw.setPenColor(Color.RED);
				}
				StdDraw.text(3 + j, 3 + i, a[j].toString());
				if (j == min) {
					StdDraw.setPenColor(Color.BLACK);
				}
			}
			exch(a, i, min);
		}
		for (int i = 0; i < N; i++) {
			StdDraw.text(3 + i, N + 3, a[i].toString());
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] a = new In().readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
