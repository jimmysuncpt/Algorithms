package com.jimmysun.algorithms.chapter1_1;

import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

public class Ex39 {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("error!");
			return;
		}
		int T = Integer.parseInt(args[0]);
		int[] num = new int[4];
		for (int i = 0; i < T; i++) {
			int N = 100;
			for (int j = 0; j < 4; j++) {
				N *= 10;
				int[] a = new int[N];
				int[] b = new int[N];
				for (int k = 0; k < N; k++) {
					a[k] = StdRandom.uniform(100000, 1000000);
					b[k] = StdRandom.uniform(100000, 1000000);
				}
				Arrays.sort(a);
				for (int k = 0; k < N; k++) {
					if (BinarySearch.indexOf(a, b[k]) != -1) {
						num[j]++;
					}
				}
			}
		}
		System.out.println("   N\t Average");
		int N = 100;
		for (int i = 0; i < 4; i++) {
			N *= 10;
			System.out.printf("%7d %9.2f\n", N, (double) num[i] / T);
		}
	}
}
