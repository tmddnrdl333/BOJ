package bj_0130;

import java.util.Scanner;

public class bj1357_0130 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		System.out.println(rev(Integer.toString(rev(A) + rev(B))));
		sc.close();

	}

	static int rev(String n) {
		int res = 0;
		for (int i = 0; i < n.length(); i++) {
			res += (n.charAt(i) - '0') * Math.pow(10, i);
		}
		return res;
	}
}
