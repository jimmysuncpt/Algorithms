package com.jimmysun.algorithms.chapter4_3;

import com.jimmysun.algorithms.chapter1_3.Queue;
import com.jimmysun.algorithms.chapter1_5.UF;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class KruskalMST {
	private Queue<Edge> mst;
	private double weight;

	public KruskalMST(EdgeWeightedGraph G) {
		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for (Edge e : G.edges()) {
			pq.insert(e);
		}
		UF uf = new UF(G.V());

		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if (uf.connected(v, w)) {
				continue;
			}
			uf.union(v, w);
			mst.enqueue(e);
			weight += e.weight();
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	/**
	 * Exercise 4.3.31
	 * 
	 * @return
	 */
	public double weight() {
		return weight;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);

		KruskalMST mst = new KruskalMST(G);
		for (Edge e : mst.edges()) {
			StdOut.println(e);
		}
		StdOut.println(mst.weight());
	}
}
