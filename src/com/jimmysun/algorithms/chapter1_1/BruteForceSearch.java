package com.jimmysun.algorithms.chapter1_1;

public class BruteForceSearch {
	public static int rank(int key, int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {
				return i;
			}
		}
		return -1;
	}
}
