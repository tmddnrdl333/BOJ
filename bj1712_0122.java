import java.util.Scanner;

public class bj1712_0122 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if (A == 0 || B >= C) {
			System.out.println(-1);
			return;
		} else {

			System.out.println(A / (C - B) + 1);

		}
	}
}
