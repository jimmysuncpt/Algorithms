package com.jimmysun.algorithms.chapter4_3;

import com.jimmysun.algorithms.chapter1_3.Queue;
import com.jimmysun.algorithms.chapter1_5.UF;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BoruvkaMST {
	private Queue<Edge> mst;
	private double weight;

	public BoruvkaMST(EdgeWeightedGraph G) {
		mst = new Queue<Edge>();
		UF uf = new UF(G.V());

		for (int t = 0; t < G.V() && mst.size() < G.V() - 1; t += t) {
			Edge[] closest = new Edge[G.V()];
			for (Edge e : G.edges()) {
				int v = e.either(), w = e.other(v);
				int i = uf.find(v), j = uf.find(w);
				if (i == j) {
					continue;
				}
				if (closest[i] == null || less(e, closest[i])) {
					closest[i] = e;
				}
				if (closest[j] == null || less(e, closest[j])) {
					closest[j] = e;
				}
			}

			for (int i = 0; i < G.V(); i++) {
				Edge e = closest[i];
				if (e != null) {
					int v = e.either(), w = e.other(v);
					if (!uf.connected(v, w)) {
						mst.enqueue(e);
						weight += e.weight();
						uf.union(v, w);
					}
				}
			}
		}

		assert check(G);
	}

	private boolean less(Edge e, Edge f) {
		return e.weight() < f.weight();
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		return weight;
	}

	private boolean check(EdgeWeightedGraph G) {
		// check total weight
		double total = 0;
		for (Edge edge : mst) {
			total += edge.weight();
		}
		if (Math.abs(total - weight) > 1E-12) {
			System.err.println("total weight not equal");
			return false;
		}

		// check that it is acyclic
		UF uf = new UF(G.V());
		for (Edge edge : mst) {
			int v = edge.either(), w = edge.other(v);
			if (uf.connected(v, w)) {
				System.err.println("it is not acyclic");
				return false;
			} else {
				uf.union(v, w);
			}
		}

		// check that it is a spanning tree
		for (Edge edge : G.edges()) {
			int v = edge.either(), w = edge.other(v);
			if (!uf.connected(v, w)) {
				System.err.println("it is not a spanning tree");
				return false;
			}
		}

		// check that it is a minimal spanning tree (cut optimality
		// conditions)
		for (Edge edge : mst) {
			uf = new UF(G.V());
			for (Edge e : mst) {
				int v = e.either(), w = e.other(v);
				if (e != edge) {
					uf.union(v, w);
				}
			}
			for (Edge e : G.edges()) {
				int v = e.either(), w = e.other(v);
				if (!uf.connected(v, w) && e.weight() < edge.weight()) {
					System.err.println("it is not a minimal spanning tree");
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);

		BoruvkaMST mst = new BoruvkaMST(G);
		for (Edge e : mst.edges()) {
			StdOut.println(e);
		}
		StdOut.println(mst.weight());
	}
}
