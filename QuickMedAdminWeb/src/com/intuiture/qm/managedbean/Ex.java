package com.intuiture.qm.managedbean;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Ex {
	Properties prop = new Properties();

	public static void main(String[] args) {
		// new Ex().resource("");

	}

	public String resource(String key) {
		try {
			InputStream in = new FileInputStream("D:/config.properties");
			prop.load(in);
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return prop.getProperty(key);
	}
}
