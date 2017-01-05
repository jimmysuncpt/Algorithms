package com.jimmysun.algorithms.chapter2_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex11 {
	private static int CUTOFF = 15;

	public static void merge(Comparable[] src, Comparable[] dest, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				dest[k] = src[j++];
			} else if (j > hi) {
				dest[k] = src[i++];
			} else if (less(src[j], src[i])) {
				dest[k] = src[j++];
			} else {
				dest[k] = src[i++];
			}
		}
	}

	public static void sort(Comparable[] a) {
		Comparable[] aux = a.clone();
		sort(aux, a, 0, a.length - 1);
	}

	private static void sort(Comparable[] src, Comparable[] dest, int lo, int hi) {
		if (hi - lo < CUTOFF) {
			insertionSort(dest, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(dest, src, lo, mid);
		sort(dest, src, mid + 1, hi);
		if (less(src[mid + 1], src[mid])) {
			merge(src, dest, lo, mid, hi);
		}
	}

	public static void insertionSort(Comparable[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
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
