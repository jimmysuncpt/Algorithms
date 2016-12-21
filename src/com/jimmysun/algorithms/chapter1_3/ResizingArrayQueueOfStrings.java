package com.jimmysun.algorithms.chapter1_3;

public class ResizingArrayQueueOfStrings {
	private String[] a = new String[1];
	private int N = 0;

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	private void resize(int max) {
		String[] temp = new String[max];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public void enqueue(String item) {
		if (N == a.length) {
			resize(2 * a.length);
		}
		a[N++] = item;
	}

	public String dequeue() {
		String item = a[0];
		for (int i = 0; i < N; i++) {
			a[i] = a[i + 1];
		}
		N--;
		if (N > 0 && N == a.length / 4) {
			resize(a.length / 2);
		}
		return item;
	}
}
