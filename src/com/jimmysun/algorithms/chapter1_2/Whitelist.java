package com.jimmysun.algorithms.chapter1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Whitelist {

	public static void main(String[] args) {
		int[] w = new In(args[0]).readAllInts();
		StaticSETofInts set = new StaticSETofInts(w);
		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (!set.contains(key)) {
				StdOut.println(key);
			}
		}
	}
}
