package com.intuiture.qm.util;

public enum SerConstants {
	STRING("str"), NUMBER("num"), DATE("date");
	public String str;

	SerConstants(String str) {
		this.str = str;
	}

	public String toString() {
		return str;
	}
}
