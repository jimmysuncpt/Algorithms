package com.jimmysun.algorithms.chapter1_2;

import java.util.Arrays;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdIn;

public class Ex09 {
	public static int rank(int key, int[] a, Counter counter) {
		return rank(key, a, 0, a.length - 1, counter);
	}

	public static int rank(int key, int[] a, int lo, int hi, Counter counter) {
		if (lo > hi) {
			return -1;
		}
		counter.increment();
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) {
			return rank(key, a, lo, mid - 1, counter);
		} else if (key > a[mid]) {
			return rank(key, a, mid + 1, hi, counter);
		} else {
			return mid;
		}
	}

	public static void main(String[] args) {
		System.out.print("N: ");
		int N = StdIn.readInt();
		int[] a = new int[N];
		System.out.print("list: ");
		for (int i = 0; i < N; i++) {
			a[i] = StdIn.readInt();
		}
		Arrays.sort(a);
		System.out.print("key: ");
		int key = StdIn.readInt();
		Counter counter = new Counter("keys");
		System.out.println(rank(key, a, counter));
		System.out.println(counter);
	}
}
