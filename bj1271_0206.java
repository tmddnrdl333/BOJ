package bj_0206;

import java.math.BigInteger;
import java.util.Scanner;

public class bj1271_0206 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger n = new BigInteger(sc.next());
		BigInteger m = new BigInteger(sc.next());
		sc.close();

		System.out.println(n.divide(m));
		System.out.println(n.remainder(m));
	}
}
