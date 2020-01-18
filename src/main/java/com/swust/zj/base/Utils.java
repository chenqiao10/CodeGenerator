package com.swust.zj.base;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	public static void main(String[] args) {
		/*
		 * List<String> tableNames = new ArrayList<String>(); tableNames.add("user_id");
		 * Utils.getModelName(tableNames); Utils.getfield(tableNames);
		 */
	}

	public static String getModelName(String x) {
		 
			System.out.println(x);
			char[] h = x.toCharArray();
			String s = h[0] + "";
			s = s.toUpperCase();
			for (int i = 0; i < h.length; i++) {
				if (h[i] == '_') {
					String s1 = h[i + 1] + "";
					s1 = s1.toUpperCase();
					h[i + 1] = s1.toCharArray()[0];
				}
			}
			h[0] = s.toCharArray()[0];
			x = String.valueOf(h);
			x = x.replace("_", "");
			System.out.println(x);
			// modelName.add(h);
		 
		return x;
	}

	public static String getfield(String x) {

		char[] h = x.toCharArray();

		for (int i = 0; i < h.length; i++) {
			if (h[i] == '_') {
				String s1 = h[i + 1] + "";
				s1 = s1.toUpperCase();
				h[i + 1] = s1.toCharArray()[0];
			}
		}

		x = String.valueOf(h);
		x = x.replace("_", "");
		System.out.println(x);

		return x;
	}
}
