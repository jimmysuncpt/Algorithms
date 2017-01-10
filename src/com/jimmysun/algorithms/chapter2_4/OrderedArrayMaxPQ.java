package com.jimmysun.algorithms.chapter2_4;

import edu.princeton.cs.algs4.StdIn;

public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;

	public OrderedArrayMaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void insert(Key v) {
		int i = N - 1;
		for (; i >= 0 && pq[i].compareTo(v) > 0; i--) {
			pq[i + 1] = pq[i];
		}
		pq[i + 1] = v;
		N++;
	}

	public Key delMax() {
		Key key = pq[--N];
		pq[N] = null;
		return key;
	}

	public static void main(String[] args) {
		OrderedArrayMaxPQ<String> pq = new OrderedArrayMaxPQ<>(100);
		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();
			if (!key.equals("*")) {
				pq.insert(key);
			} else {
				System.out.print(pq.delMax() + " ");
			}
		}
		System.out.println("(" + pq.size() + " left on queue)");
	}
}
