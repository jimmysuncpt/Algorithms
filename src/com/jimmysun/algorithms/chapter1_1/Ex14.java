package com.jimmysun.algorithms.chapter1_1;

public class Ex14 {
	public static int lg(int N) {
		int i, n;
		for (i = 0, n = 1; n <= N; i++) {
			n *= 2;
		}
		return i - 1;
	}

	public static void main(String[] args) {
		System.out.println(lg(1025));
	}
}
