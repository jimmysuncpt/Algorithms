package com.jimmysun.algorithms.chapter3_1;

import edu.princeton.cs.algs4.StdIn;

public class TestBinarySearch {

	public static void main(String[] args) {
		BinarySearchST<String, Integer> st = new BinarySearchST<>(1000000);
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String s : st.keys()) {
			System.out.println(s + " " + st.get(s));
		}
		System.out.println("min(): " + st.min());
		System.out.println("max(): " + st.max());
		System.out.println("floor(\"F\"): " + st.floor("F"));
		System.out.println("ceiling(\"C\"): " + st.ceiling("C"));
		System.out.println("select(0): " + st.select(0));
		System.out.println("rank(\"R\"): " + st.rank("R"));
		System.out.println("deleteMin():");
		st.deleteMin();
		for (String s : st.keys()) {
			System.out.println(s + " " + st.get(s));
		}
		System.out.println("deleteMax():");
		st.deleteMax();
		for (String s : st.keys()) {
			System.out.println(s + " " + st.get(s));
		}
	}
}
