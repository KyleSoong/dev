package com.song.dev;

import java.time.LocalDate;

public class JavaTest {
	public static void main(String[] args) {
		String str = "";
		StringBuffer sb = new StringBuffer();
		StringBuilder sbld = new StringBuilder();
		long start = 0L;
		long end = 0L;
		start = System.currentTimeMillis();
		for (long i = 0; i < 100000; i++) {
			str = str + "a";
		}
		end = System.currentTimeMillis();
		System.out.println("使用string的时间是:" + (end - start) + "毫秒!");
		//////////////////
		start = System.currentTimeMillis();
		for (long i = 0; i < 100000; i++) {
			sb.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("使用StringBuffer的时间是:" + (end - start) + "毫秒!");
		/////////////////
		start = System.currentTimeMillis();
		for (long i = 0; i < 100000; i++) {
			sbld.append("a");
		}
		end = System.currentTimeMillis();
		System.out.println("使用StringBuilder的时间是:" + (end - start) + "毫秒!");
	}
}
