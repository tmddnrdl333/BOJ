import java.util.Scanner;

public class bj1065_0122 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (hTest(i) == true)
				cnt++;
		}
		System.out.println(cnt);
	}

	static boolean hTest(int num) {
		int len = lengthReturn(num);
		if (len <= 2) {
			return true;
		} else if (len == 4) {
			return false;
		}

		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = num / (int) Math.pow(10, 2 - i);
			num = num - arr[i] * (int) Math.pow(10, 2 - i);
		}
		if ((arr[0] + arr[2]) % 2 == 0 && arr[1] == (arr[0] + arr[2]) / 2) {
			return true;
		}
		return false;
	}

	static int lengthReturn(int num) {
		int res = 0;
		for (int i = 1; i <= 4; i++) {
			if (num / (int) Math.pow(10, i) != 0) {
			} else {
				res = i;
				break;
			}
		}
		return res;
	}
}
