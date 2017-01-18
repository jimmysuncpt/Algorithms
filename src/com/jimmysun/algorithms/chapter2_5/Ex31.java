package com.jimmysun.algorithms.chapter2_5;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdRandom;

public class Ex31 {

	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		int N = Integer.parseInt(args[1]);
		int T = Integer.parseInt(args[2]);
		long count = 0;
		for (int i = 0; i < T; i++) {
			int[] a = new int[N];
			for (int j = 0; j < N; j++) {
				a[j] = StdRandom.uniform(M);
			}
			Arrays.sort(a);
			for (int j = 1; j < a.length; j++) {
				if (a[j - 1] != a[j]) {
					count++;
				}
			}
		}
		System.out.printf("Empirical: %.2f\n", (double) count / T);
		double alpha = (double) N / M;
		System.out.printf("Estimate: %.2f\n", M * (1 - Math.exp(-alpha)));
	}
}
