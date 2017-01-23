package com.jimmysun.algorithms.chapter3_1;

import com.jimmysun.algorithms.chapter1_3.Queue;

public class SequentialSearchST<Key, Value> {
	private Node first;
	private int N = 0;

	private class Node {
		Key key;
		Value val;
		Node next;

		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}

	public Value get(Key key) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				return x.val;
			}
		}
		return null;
	}

	public void put(Key key, Value val) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
		N++;
	}

	// Exercise 3.1.5
	public int size() {
		return N;
	}

	public void delete(Key key) {
		first = delete(first, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		if (x.key.equals(key)) {
			N--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<>();
		for (Node x = first; x != null; x = x.next) {
			queue.enqueue(x.key);
		}
		return queue;
	}
}
