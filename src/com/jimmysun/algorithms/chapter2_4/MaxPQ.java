package com.jimmysun.algorithms.chapter2_4;

public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	private Key min;

	public MaxPQ(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void insert(Key v) {
		pq[++N] = v;
		if (N == 1 || min.compareTo(v) > 0) {
			min = v;
		}
		swim(N);
	}

	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		sink(1);
		if (isEmpty()) {
			min = null;
		}
		return max;
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1)) {
				j++;
			}
			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	/**
	 * Exercise 2.4.27
	 * 
	 * @return
	 */
	public Key min() {
		return min;
	}
}
