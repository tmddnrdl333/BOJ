package bj_0131;

import java.util.Scanner;

public class bj1408_0131 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();

		int ha = A.charAt(0) * 10 + A.charAt(1);
		int hb = B.charAt(0) * 10 + B.charAt(1);

		int ma = A.charAt(3) * 10 + A.charAt(4);
		int mb = B.charAt(3) * 10 + B.charAt(4);

		int sa = A.charAt(6) * 10 + A.charAt(7);
		int sb = B.charAt(6) * 10 + B.charAt(7);

		int re = (hb - ha) * 3600 + (mb - ma) * 60 + (sb - sa);

		re = (re > 0) ? re : (24 * 3600 + re);

		int hr = re / 3600;
		int mr = (re - hr * 3600) / 60;
		int sr = re - hr * 3600 - mr * 60;

		String res = String.format("%02d", hr) + ":" + String.format("%02d", mr) + ":" + String.format("%02d", sr);

		System.out.println(res);
	}
}
