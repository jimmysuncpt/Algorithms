package com.jimmysun.algorithms.chapter1_1;

public class Ex09 {
    /**
     * 支持有符号整数
     */
    private static String intToBinaryStr1(int value) {
        //idea 注意 0 和 '0' 的区别! 参考链接 https://ybzbxcc.github.io/2016/08/05/NULL,0,%270%27/
        char[] Digits = new char[]{'0', '1'};
        int bufLen = 32;
        int index = bufLen;
        char[] result = new char[bufLen];
        do {
            //idea 使用 & 符合相对除 2 提升一定性能
            result[--index] = Digits[value & 1];
            value = value >>> 1;
        } while (value != 0);
        return new String(result, index, bufLen - index);
    }
    
    /**
     * 不支持有符号的整数
     */
    private static String intToBinaryStr2(int source) {
        int intBuf = 32;
        char[] DIGITS = new char[]{'0', '1'};
        char[] result = new char[intBuf];
        int i = intBuf;
        while (source != 0) {
            result[--i] = DIGITS[source % 2];
            source >>= 1;
        }
        
        return new String(result, i, intBuf - i);
    }
    
    public static String toBinaryString(int N) {
        if (N == 0) {
            return "0";
        }
        String s = "";
        while (N > 0) {
            s = N % 2 + s;
            N /= 2;
        }
        return s;
    }
    
    public static void main(String[] args) {
        int value = -1024;
        System.out.println("value:"+ value + ";result for Integer.toBinaryString()>>>\r\n\t"     + Integer.toBinaryString(value));
        System.out.println("value:"+ value + ";result for intToBinaryStr1>>>\r\n\t"              + intToBinaryStr1(value));
        System.out.println("value:"+ value + ";result for intToBinaryStr2>>>\r\n\t"              + intToBinaryStr2(value));
        System.out.println("value:"+ value + ";result for toBinaryString>>>\r\n\t"               + toBinaryString(value));
    }
}
