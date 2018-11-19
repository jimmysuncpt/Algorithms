package com.jimmysun.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdIn;

public class Ex30 {
	public static int euclid(int p, int q) {
		if (p < q) {
			int t = p;
			p = q;
			q = t;
		}
		if (q == 0) {
			return p;
		} else {
			return euclid(q, p % q);
		}
	}

	public static void main(String[] args) {
		int N = StdIn.readInt();
		boolean[][] a = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				a[i][j] = euclid(i, j) == 1;
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
