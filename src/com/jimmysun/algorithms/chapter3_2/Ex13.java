package com.jimmysun.algorithms.chapter3_2;

import edu.princeton.cs.algs4.StdIn;

public class Ex13<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {
		private Key key;
		private Value val;
		private Node left, right;

		public Node(Key key, Value val) {
			this.key = key;
			this.val = val;
		}
	}

	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp == 0) {
				return x.val;
			} else if (cmp < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		return null;
	}

	public void put(Key key, Value val) {
		if (root == null) {
			root = new Node(key, val);
			return;
		}
		Node x = root, parent = null;
		while (x != null) {
			parent = x;
			int cmp = key.compareTo(x.key);
			if (cmp == 0) {
				x.val = val;
				return;
			} else if (cmp < 0) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		int cmp = key.compareTo(parent.key);
		if (cmp < 0) {
			parent.left = new Node(key, val);
		} else {
			parent.right = new Node(key, val);
		}
	}

	public static void main(String[] args) {
		Ex13<String, Integer> st = new Ex13<>();
		for (int i = 0; !StdIn.isEmpty(); i++) {
			String key = StdIn.readString();
			st.put(key, i);
		}
		for (String key : args) {
			System.out.println(key + " : " + st.get(key));
		}
	}
}
