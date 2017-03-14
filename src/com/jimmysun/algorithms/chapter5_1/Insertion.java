package com.jimmysun.algorithms.chapter5_1;

public class Insertion {
	public static void sort(String[] a, int lo, int hi, int d) {
		// 从第d个字符开始对a[lo]到a[hi]排序
		for (int i = lo; i < hi; i++) {
			for (int j = i; j > lo && less(a[j], a[j - 1], d); j++) {
				exch(a, j, j - 1);
			}
		}
	}

	private static boolean less(String v, String w, int d) {
		return v.substring(d).compareTo(w.substring(d)) < 0;
	}

	private static void exch(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
