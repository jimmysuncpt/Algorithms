package com.jimmysun.algorithms.chapter1_1;

import java.util.Arrays;

public class Ex29 {
	public static int rank(int key, int[] a) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (a[mid] == key) {
				while (mid >= 0 && a[mid] == key){
					mid--;
				}
				return ++mid;
			} else if (a[mid] < key){
				low = mid + 1;
			} else if (a[mid] > key){
				high =mid - 1;
			}
		}
		return -1;
	}

	public static int count(int key, int[] a) {
		int num = 1;
		int pos = rank(key, a);
		while (pos < a.length - 1 && a[pos] == a[++pos]) {
			num++;
		}
		return num;
	}

	public static void main(String[] args) {
		int[] a = new int[] {84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 33, 16, 77, 11, 29, 11, 29, 77, 77};
		Arrays.sort(a);
		System.out.println(rank(29, a));
		System.out.println(count(48, a));
	}
}
