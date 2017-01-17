package com.jimmysun.algorithms.chapter2_5;

import com.jimmysun.algorithms.chapter2_2.Ex19;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class KendallTau {
	public static int distance(int[] a, int[] b) {
		int n = a.length;
		int[] aIndex = new int[n];
		for (int i = 0; i < n; i++) {
			aIndex[a[i]] = i;
		}
		Integer[] bIndexInA = new Integer[n];
		for (int i = 0; i < n; i++) {
			bIndexInA[i] = aIndex[b[i]];
		}
		return Ex19.count(bIndexInA);
	}

	public static void main(String[] args) {
		int n = StdIn.readInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i;
			b[i] = i;
		}
		StdRandom.shuffle(a);
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		StdRandom.shuffle(b);
		for (int i = 0; i < n; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		System.out.println("distance: " + distance(a, b));
	}
}
