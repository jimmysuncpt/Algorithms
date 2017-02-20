package com.jimmysun.algorithms.chapter4_2;

import com.jimmysun.algorithms.chapter1_3.Queue;

public class Ex30 {
	private Queue<Integer> order;

	public Ex30(Digraph G) {
		int[] indegrees = new int[G.V()];
		Queue<Integer> sources = new Queue<>();
		for (int v = 0; v < G.V(); v++) {
			indegrees[v] = G.indegree(v);
			if (indegrees[v] == 0) {
				sources.enqueue(v);
			}
		}
		order = new Queue<>();
		while (!sources.isEmpty()) {
			int source = sources.dequeue();
			order.enqueue(source);
			for (int i : G.adj(source)) {
				if (--indegrees[i] == 0) {
					sources.enqueue(i);
				}
			}
		}
		if (order.size() != G.V()) {
			order = null;
		}
	}

	public Iterable<Integer> order() {
		return order;
	}

	public boolean hasOrder() {
		return order != null;
	}

	public static void main(String[] args) {
		SymbolDigraph sg = new SymbolDigraph(args[0], args[1]);
		Ex30 ex = new Ex30(sg.G());
		if (ex.hasOrder()) {
			for (int v : ex.order()) {
				System.out.println(sg.name(v));
			}
		} else {
			System.out.println("Does not have order");
		}
	}
}
