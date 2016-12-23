package com.jimmysun.algorithms.chapter1_4;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ThreeSum {
	public static int count(int[] a) {
		int N = a.length;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		int[] a = new In(args[0]).readAllInts();
		StdOut.println(count(a));
	}
}
