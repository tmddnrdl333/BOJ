package ps.BOJ._02000_02999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 16,360kb
// 540ms

public class Main_2239_스도쿠 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] map = new int[9][9];

	static List<Integer> zero = new ArrayList<>();
	static int size = 0;

	public static void main(String[] args) throws IOException {
		for (int i = 0; i < 9; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				int cur = str.charAt(j) - '0';
				map[i][j] = cur;
				if (cur == 0)
					zero.add(i * 9 + j);
			}
		}
		size = zero.size();
		fill(0);
	}

	// li(list index)번째 빈칸 채우기
	public static void fill(int li) throws IOException {
		if (li == size) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++)
					sb.append(map[i][j]);
				sb.append("\n");
			}
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			System.exit(0);
			return;
		}
		int idx = zero.get(li);
		int r = idx / 9, c = idx % 9;
		for (int i = 1; i < 10; i++)
			// i행, j열, i/3*3+j/3블럭에 이게 될까?
			if (isValid(r, c, i, li)) {
				map[r][c] = i;
				fill(li + 1);
				map[r][c] = 0;
			}
	}

	// r,c에, num이라는 숫자가, li번째에 들어가도 될까?
	public static boolean isValid(int r, int c, int num, int li) {
		for (int i = 0; i < 9; i++) {
			if (map[r][i] == num)
				return false;
			if (map[i][c] == num)
				return false;
		}
		int sr = r / 3 * 3, sc = c / 3 * 3;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (map[sr + i][sc + j] == num)
					return false;
		return true;
	}
}