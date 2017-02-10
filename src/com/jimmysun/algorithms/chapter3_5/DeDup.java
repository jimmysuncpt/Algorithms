package com.jimmysun.algorithms.chapter3_5;

import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DeDup {

	public static void main(String[] args) {
		SET<String> set = new SET<String>();
		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();
			if (!set.contains(key)) {
				set.add(key);
				StdOut.print(key + " ");
			}
		}
	}
}
