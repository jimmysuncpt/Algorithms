package com.jimmysun.algorithms.chapter6;

import com.jimmysun.algorithms.chapter2_3.Quick3way;

public class SuffixArray {
	private final String[] suffixes;
	private final int N;

	public SuffixArray(String s) {
		N = s.length();
		suffixes = new String[N];
		for (int i = 0; i < N; i++) {
			suffixes[i] = s.substring(i);
		}
		Quick3way.sort(suffixes);
	}

	public int length() {
		return N;
	}

	public String select(int i) {
		return suffixes[i];
	}

	public int index(int i) {
		return N - suffixes[i].length();
	}

	private static int lcp(String s, String t) {
		int N = Math.min(s.length(), t.length());
		for (int i = 0; i < N; i++) {
			if (s.charAt(i) != t.charAt(i)) {
				return i;
			}
		}
		return N;
	}

	public int lcp(int i) {
		return lcp(suffixes[i], suffixes[i - 1]);
	}

	public int rank(String key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(suffixes[mid]);
			if (cmp < 0) {
				hi = mid - 1;
			} else if (cmp > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}
}
