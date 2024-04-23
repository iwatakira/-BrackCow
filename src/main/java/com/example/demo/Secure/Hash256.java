package com.example.demo.Secure;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class Hash256 {
	/**
	 * 文字列をハッシュ化
	 * @param input
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String HashStringSHA256(String input){
		try {
			MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
			byte[] sha256Byte = sha256.digest(input.getBytes());
			HexFormat hex = HexFormat.of().withLowerCase();
			String hexString = hex.formatHex(sha256Byte);
			return hexString;
		} catch(NoSuchAlgorithmException e) {
			return null;
		}
	}
}
