package com.jimmysun.algorithms.chapter3_2;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

public class Ex25 {
	public static BST<String, Integer> balance(String[] a) {
		Arrays.sort(a);
		BST<String, Integer> bst = new BST<>();
		balance(bst, a, 0, a.length - 1);
		return bst;
	}

	private static void balance(BST<String, Integer> bst, String[] a, int lo, int hi) {
		if (lo > hi) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		bst.put(a[mid], mid);
		balance(bst, a, lo, mid - 1);
		balance(bst, a, mid + 1, hi);
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		BST<String, Integer> bst = balance(a);
		for (String key : bst.keys()) {
			System.out.println(key + " " + bst.get(key));
		}
	}
}
