package com.jimmysun.algorithms.chapter1_3;

public class Josephus {

	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		Queue<Integer> queue = new Queue<>();
		for (int i = 0; i < N; i++) {
			queue.enqueue(i);
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < M - 1; i++) {
				queue.enqueue(queue.dequeue());
			}
			System.out.print(queue.dequeue() + " ");
		}
		System.out.println();
	}
}
