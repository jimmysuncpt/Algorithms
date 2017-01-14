package com.jimmysun.algorithms.chapter2_5;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdIn;

public class Domain implements Comparable<Domain> {
	private String domain;
	private String[] name;

	public Domain(String domain) {
		this.domain = domain;
		name = domain.split("\\.");
	}

	@Override
	public String toString() {
		return domain;
	}

	@Override
	public int compareTo(Domain that) {
		int i = this.name.length - 1, j = that.name.length - 1;
		for (; i >= 0 && j >= 0; i--, j--) {
			int result = this.name[i].compareTo(that.name[j]);
			if (result != 0) {
				return result;
			}
		}
		return i - j;
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Domain[] domains = new Domain[a.length];
		for (int i = 0; i < domains.length; i++) {
			domains[i] = new Domain(a[i]);
		}
		Arrays.sort(domains);
		for (int i = 0; i < domains.length; i++) {
			System.out.println(domains[i]);
		}
	}
}
