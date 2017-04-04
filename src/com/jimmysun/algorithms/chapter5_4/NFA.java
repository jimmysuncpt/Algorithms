package com.jimmysun.algorithms.chapter5_4;

import com.jimmysun.algorithms.chapter1_3.Bag;
import com.jimmysun.algorithms.chapter1_3.Stack;
import com.jimmysun.algorithms.chapter4_2.Digraph;
import com.jimmysun.algorithms.chapter4_2.DirectedDFS;

public class NFA {
	private char[] re; // 匹配转换
	private Digraph G; // epsilon转换
	private int M; // 状态数量

	public NFA(String regexp) {
		Stack<Integer> ops = new Stack<Integer>();
		re = regexp.toCharArray();
		M = re.length;
		G = new Digraph(M + 1);

		for (int i = 0; i < M; i++) {
			int lp = i;
			if (re[i] == '(' || re[i] == '|') {
				ops.push(i);
			} else if (re[i] == ')') {
				int or = ops.pop();
				if (re[or] == '|') {
					lp = ops.pop();
					G.addEdge(lp, or + 1);
					G.addEdge(or, i);
				} else {
					lp = or;
				}
			}
			if (i < M - 1 && re[i + 1] == '*') {
				G.addEdge(lp, i + 1);
				G.addEdge(i + 1, lp);
			}
			if (re[i] == '(' || re[i] == '*' || re[i] == ')') {
				G.addEdge(i, i + 1);
			}
		}
	}

	public boolean recognizes(String txt) {
		Bag<Integer> pc = new Bag<Integer>();
		DirectedDFS dfs = new DirectedDFS(G, 0);
		for (int v = 0; v < G.V(); v++) {
			if (dfs.marked(v)) {
				pc.add(v);
			}
		}

		for (int i = 0; i < txt.length(); i++) {
			Bag<Integer> match = new Bag<Integer>();
			for (int v : pc) {
				if (v < M) {
					if (re[v] == txt.charAt(i) || re[v] == '.') {
						match.add(v + 1);
					}
				}
			}
			pc = new Bag<Integer>();
			dfs = new DirectedDFS(G, match);
			for (int v = 0; v < G.V(); v++) {
				if (dfs.marked(v)) {
					pc.add(v);
				}
			}
		}

		for (int v : pc) {
			if (v == M) {
				return true;
			}
		}
		return false;
	}
}
