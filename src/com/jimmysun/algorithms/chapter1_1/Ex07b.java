package com.jimmysun.algorithms.chapter1_1;

import edu.princeton.cs.algs4.StdOut;

public class Ex07b {
	public static void main(String[] args) {
		int sum = 0;
		// (n * (n + 1)) / 2
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(i + " * " + j + " ");
				sum++;
			}
			System.out.println();
		}
		StdOut.println(sum);
	}
}
