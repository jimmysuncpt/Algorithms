package com.jimmysun.algorithms.chapter2_2;

import edu.princeton.cs.algs4.In;

public class Ex20 {
	private static int[] aux;

	private static int[] merge(Comparable[] a, int lo, int mid, int hi, int[] perm) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			aux[k] = perm[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				perm[k] = aux[j++];
			} else if (j > hi) {
				perm[k] = aux[i++];
			} else if (less(a[aux[j]], a[aux[i]])) {
				perm[k] = aux[j++];
			} else {
				perm[k] = aux[i++];
			}
		}
		return perm;
	}

	public static int[] sort(Comparable[] a) {
		int[] perm = new int[a.length];
		aux = new int[a.length];
		for (int i = 0; i < perm.length; i++) {
			perm[i] = i;
		}
		return sort(a, 0, a.length - 1, perm);
	}

	private static int[] sort(Comparable[] a, int lo, int hi, int[] perm) {
		if (hi <= lo) {
			return perm;
		}
		int mid = lo + (hi - lo) / 2;
		perm = sort(a, lo, mid, perm);
		perm = sort(a, mid + 1, hi, perm);
		perm = merge(a, lo, mid, hi, perm);
		return perm;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public static void main(String[] args) {
		String[] a = new In().readAllStrings();
		int[] perm = sort(a);
		for (int i = 0; i < perm.length; i++) {
			System.out.print(perm[i] + " ");
		}
		System.out.println();
	}
}
