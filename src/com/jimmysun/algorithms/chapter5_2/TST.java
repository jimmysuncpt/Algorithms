package com.jimmysun.algorithms.chapter5_2;

import com.jimmysun.algorithms.chapter1_3.Queue;

public class TST<Value> {
	private Node root;

	private class Node {
		char c;
		Node left, mid, right;
		Value val;
	}

	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null) {
			return null;
		}
		return (Value) x.val;
	}

	private Node get(Node x, String key, int d) {
		if (x == null) {
			return null;
		}
		char c = key.charAt(d);
		if (c < x.c) {
			return get(x.left, key, d);
		} else if (c > x.c) {
			return get(x.right, key, d);
		} else if (d < key.length() - 1) {
			return get(x.mid, key, d + 1);
		} else {
			return x;
		}
	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		char c = key.charAt(d);
		if (x == null) {
			x = new Node();
			x.c = c;
		}
		if (c < x.c) {
			x.left = put(x.left, key, val, d);
		} else if (c > x.c) {
			x.right = put(x.right, key, val, d);
		} else if (d < key.length() - 1) {
			x.mid = put(x.mid, key, val, d + 1);
		} else {
			x.val = val;
		}
		return x;
	}

	// Exercise 5.2.9
	public String longestPrefixOf(String s) {
		if (s.length() == 0)
			return null;
		int length = 0;
		Node x = root;
		int i = 0;
		while (x != null && i < s.length()) {
			char c = s.charAt(i);
			if (c < x.c) {
				x = x.left;
			} else if (c > x.c) {
				x = x.right;
			} else {
				i++;
				if (x.val != null) {
					length = i;
				}
				x = x.mid;
			}
		}
		return s.substring(0, length);
	}

	public Iterable<String> keys() {
		return keysWithPrefix("");
	}

	private Iterable<String> keysWithPrefix(String pre) {
		Queue<String> q = new Queue<>();
		collect(get(root, pre, 0).mid, pre, q);
		return q;
	}

	private void collect(Node x, String pre, Queue<String> q) {
		if (x == null) {
			return;
		}
		if (x.val != null) {
			q.enqueue(pre);
		}
		collect(x.left, pre, q);
		collect(x.right, pre, q);
		collect(x.mid, pre + x.c, q);
	}

	public Iterable<String> keysThatMatch(String pat) {
		Queue<String> q = new Queue<>();
		collect(root, "", pat, q);
		return q;
	}

	private void collect(Node x, String pre, String pat, Queue<String> q) {
		if (x == null) {
			return;
		}
		int d = pre.length();
		char c = pat.charAt(d);
		if (c == '.' || c < x.c) {
			collect(x.left, pre, pat, q);
		}
		if (c == '.' || c > x.c) {
			collect(x.right, pre, pat, q);
		}
		if (c == '.' || c == x.c) {
			if (d + 1 == pat.length() && x.val != null) {
				q.enqueue(pre + c);
			}
			if (d + 1 < pat.length()) {
				collect(x.mid, pre + c, pat, q);
			}
		}
	}
}
