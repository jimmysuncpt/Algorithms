package com.jimmysun.algorithms.chapter2_2;

import edu.princeton.cs.algs4.In;

public class Ex19 {
	private static Comparable[] aux;

	private static int merge(Comparable[] a, int lo, int mid, int hi, int count) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
				count += j - k - 1;
			} else {
				a[k] = aux[i++];
			}
		}
		return count;
	}

	public static int count(Comparable[] a) {
		aux = new Comparable[a.length];
		return count(a, 0, a.length - 1, 0);
	}

	private static int count(Comparable[] a, int lo, int hi, int count) {
		if (hi <= lo) {
			return count;
		}
		int mid = lo + (hi - lo) / 2;
		count = count(a, lo, mid, count);
		count = count(a, mid + 1, hi, count);
		return merge(a, lo, mid, hi, count);
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void main(String[] args) {
		String[] a = new In().readAllStrings();
		System.out.println(count(a));
	}
}
