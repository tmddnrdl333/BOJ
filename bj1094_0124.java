package bj_0124;

import java.util.Scanner;

public class bj1094_0124 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		sc.close();
		String binX = Integer.toBinaryString(X);
		int res = 0;
		for (int i = 0; i < binX.length(); i++)
			if (binX.charAt(i) == '1')
				res++;
		System.out.println(res);

	}
}
