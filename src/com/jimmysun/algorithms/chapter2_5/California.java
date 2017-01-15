package com.jimmysun.algorithms.chapter2_5;

import java.util.Arrays;
import java.util.Comparator;

import edu.princeton.cs.algs4.StdIn;

public class California {
	public static class CandidateComparator implements Comparator<String> {
		private static final String ORDER = "RWQOJMVAHBSGZXNTCIEKUPDYFL";

		@Override
		public int compare(String str1, String str2) {
			int min = Math.min(str1.length(), str2.length());
			for (int i = 0; i < min; i++) {
				int index1 = ORDER.indexOf(str1.charAt(i));
				int index2 = ORDER.indexOf(str2.charAt(i));
				if (index1 != index2) {
					return index1 - index2;
				}
			}
			return str1.length() - str2.length();
		}
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Arrays.sort(a, new California.CandidateComparator());
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
