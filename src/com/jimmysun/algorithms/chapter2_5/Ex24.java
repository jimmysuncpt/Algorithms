package com.jimmysun.algorithms.chapter2_5;

public class Ex24<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N = 0;
	private int[] time;
	private int timestamp;

	public Ex24(int maxN) {
		pq = (Key[]) new Comparable[maxN + 1];
		time = new int[maxN];
		timestamp = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public void insert(Key v) {
		pq[++N] = v;
		time[N] = ++timestamp;
		swim(N);
	}

	public Key delMax() {
		Key max = pq[1];
		exch(1, N--);
		pq[N + 1] = null;
		time[N + 1] = 0;
		sink(1);
		return max;
	}

	private boolean less(int i, int j) {
		if (pq[i].compareTo(pq[j]) < 0) {
			return true;
		} else if (pq[i].compareTo(pq[j]) > 0) {
			return false;
		}
		return time[i] < time[j];
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
		int temp = time[i];
		time[i] = time[j];
		time[j] = temp;
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
}
