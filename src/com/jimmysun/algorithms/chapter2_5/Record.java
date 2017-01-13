package com.jimmysun.algorithms.chapter2_5;

public class Record implements Comparable<Record> {
	private String word;
	private int freq;

	public Record(String word) {
		this.word = word;
		freq = 1;
	}

	public String getWord() {
		return word;
	}

	public int getFreq() {
		return freq;
	}

	public void addFreq() {
		freq++;
	}

	@Override
	public int compareTo(Record that) {
		if (this.freq > that.freq) {
			return -1;
		} else if (this.freq < that.freq) {
			return 1;
		} else {
			return 0;
		}
	}
}
