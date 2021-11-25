package com.jimmysun.algorithms.chapter1_1;

import java.util.Arrays;

public class Ex29 {
	public static int rank(int key, int[] a) {
		int lo = 0;
		int hi = a.length - 1;

		while (hi >= lo) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] >= key) {
				if (mid == 0) {
					return 0;
				}
				if (a[mid - 1] < key) {
					return mid;
				} else {
					hi = mid - 1;
				}
			} else {
				if (mid == a.length - 1) {
					return a.length;
				}

				if (a[mid + 1] >= key) {
					return mid + 1;
				} else {
					lo = mid + 1;
				}
			}
		}

		return 0;
	}

	public static int count(int key, int[] a) {
		int rank = rank(key, a);

		if (rank == a.length || key != a[rank]) {
			return 0;
		}

		int lo = rank;
		int hi = a.length - 1;
		int lastIndex = 0;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] > key) {
				hi = mid - 1;
			} else if (a[mid] < key) {
				lo = mid + 1;
			} else if (a[mid] == key) {
				if (mid == a.length - 1) {
					lastIndex = a.length - 1;
					break;
				}

				if (a[mid + 1] > key) {
					lastIndex = mid;
					break;
				} else {
					lo = mid + 1;
				}
			}
		}

		return lastIndex - rank + 1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 33, 16, 77, 11, 29, 11, 29, 77, 77 };
		Arrays.sort(a);
		System.out.println(rank(29, a));
		System.out.println(count(48, a));
		// test the condition that the key not exist in the array
		System.out.println(rank(14, a));
		System.out.println(count(14, a));
	}
}
