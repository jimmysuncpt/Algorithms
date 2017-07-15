package com.jimmysun.algorithms.chapter2_4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Heap {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int k = N / 2; k >= 1; k--) {
			sink(a, k, N);
		}
		while (N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}

	private static void sink(Comparable[] pq, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(pq, j, j + 1)) {
				j++;
			}
			if (!less(pq, k, j)) {
				break;
			}
			exch(pq, k, j);
			k = j;
		}
	}

	private static boolean less(Comparable[] pq, int i, int j) {
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}

	private static void exch(Object[] pq, int i, int j) {
		Object swap = pq[i - 1];
		pq[i - 1] = pq[j - 1];
		pq[j - 1] = swap;
	}

	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Heap.sort(a);
		show(a);
	}
}
