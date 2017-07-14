package com.song.dev;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5Test {
	public static void main(String[] args) {
		String algorithmName = "md5";
		String str = "skh83@163.com#skh83";
		String res = new SimpleHash(algorithmName, str).toHex();
		System.out.println(res);
	}
}
