package com.jimmysun.algorithms.chapter4_3;

import com.jimmysun.algorithms.chapter1_3.Queue;

import edu.princeton.cs.algs4.MinPQ;

public class LazyPrimMST {
	private boolean[] marked;
	private Queue<Edge> mst;
	private MinPQ<Edge> pq;

	public LazyPrimMST(EdgeWeightedGraph G) {
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();

		visit(G, 0);
		while (!pq.isEmpty()) {
			Edge e = pq.delMin();

			int v = e.either(), w = e.other(v);
			if (marked[v] && marked[w]) {
				continue;
			}
			mst.enqueue(e);
			if (!marked[v]) {
				visit(G, v);
			}
			if (!marked[w]) {
				visit(G, w);
			}
		}
	}

	private void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			if (!marked[e.other(v)]) {
				pq.insert(e);
			}
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}
}
