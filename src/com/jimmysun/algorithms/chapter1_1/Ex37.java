package com.jimmysun.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdRandom;

public class Ex37 {
	public static void shuffle(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			// between i and N-1
			int r = StdRandom.uniform(N);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Error");
			return;
		}
		int M = Integer.parseInt(args[0]), N = Integer.parseInt(args[1]);
		int[] a = new int[M];
		int[][] num = new int[M][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				a[j] = j;
			}
			shuffle(a);
			for (int j = 0; j < M; j++) {
				num[a[j]][j]++;
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(num[i][j] + " ");
			}
			System.out.println();
		}
	}
}
