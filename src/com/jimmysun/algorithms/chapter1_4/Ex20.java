package com.jimmysun.algorithms.chapter1_4;

import com.jimmysun.algorithms.chapter1_1.BinarySearch;

import edu.princeton.cs.algs4.StdIn;

public class Ex20 {
	private static int max(int[] a, int lo, int hi) {
		int mid = (lo + hi) / 2;
		if (mid > 0 && a[mid] < a[mid - 1]) {
			return max(a, lo, mid - 1);
		} else if (mid < a.length - 1 && a[mid] < a[mid + 1]) {
			return max(a, mid + 1, hi);
		} else {
			return mid;
		}
	}

	public static int max(int[] a) {
		return max(a, 0, a.length - 1);
	}

	/**
	 * Binary search in decreasing order
	 * 
	 * @param key
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	public static int rank(int key, int[] a, int lo, int hi) {
		if (lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		if (key > a[mid]) {
			return rank(key, a, lo, mid - 1);
		} else if (key < a[mid]) {
			return rank(key, a, mid + 1, hi);
		} else {
			return mid;
		}
	}

	public static boolean contains(int[] a, int key) {
		int max = max(a);
		if (BinarySearch.rank(key, a, 0, max) != -1) {
			return true;
		} else if (rank(key, a, max + 1, a.length - 1) != -1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.print("Length: ");
		int N = StdIn.readInt();
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = StdIn.readInt();
		}
		System.out.print("Key: ");
		System.out.println(contains(a, StdIn.readInt()));
	}
}
