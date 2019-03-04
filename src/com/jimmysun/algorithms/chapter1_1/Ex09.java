package com.jimmysun.algorithms.chapter1_1;

public class Ex09 {    
    public static String toBinaryString(int value) {
        if (value == 0) {
            return "0";
        }
        int bufLen = 32;
        int index = bufLen;
        char[] result = new char[bufLen];
        do {
            // 使用 & 符合相对除 2 提升一定性能
            result[--index] = (char)('0' + (value & 1));
            value = value >>> 1;
        } while (value != 0);
        return new String(result, index, bufLen - index);
    }
    
    public static void main(String[] args) {
        int value = -1024;
        System.out.println("value:"+ value + "; result for toBinaryString>>>\r\n\t" + toBinaryString(value));
    }
}
