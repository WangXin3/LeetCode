package com.wxx.code3to9;

/**
 * @author 她爱微笑
 * @date 2019/10/14
 * 将空格替换为%20
 */
public class ReplaceSpace {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("A B C D E ");
		String s = replaceSpace1(sb);
		System.out.println("s = " + s);
	}


	public static String replaceSpace1(StringBuffer str) {
		// p1 原字符串长度
		int p1 = str.length() - 1;
		for (int i = 0; i <= p1; i++) {
			// 如果这个字符为空格
			if (str.charAt(i) == ' ') {
				// 往后面追加两个任意字符
				str.append("  ");
			}
		}

		// p2 欲替换完空格的字符串长度
		int p2 = str.length() - 1;
		while (p1 > 0 && p2 > p1) {
			char c = str.charAt(p1--);
			if (c == ' ') {
				str.setCharAt(p2--, '0');
				str.setCharAt(p2--, '2');
				str.setCharAt(p2--, '%');
			} else {
				str.setCharAt(p2--, c);
			}
		}

		return str.toString();
	}
}
