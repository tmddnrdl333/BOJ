package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 12,124kb
// 5592ms

public class Main_9663_N_Queen {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N, cnt = 0;
	static int[] col;

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		col = new int[N];

		nQueen(0);

		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();

	}

	public static void nQueen(int rowNo) {

		if (!isAvailable(rowNo - 1)) {
			return;
		}

		if (rowNo == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			// cnt행 i열에 두기
			col[rowNo] = i;
			nQueen(rowNo + 1);
		}

	}

	public static boolean isAvailable(int rowNo) {
		for (int i = 0; i < rowNo; i++) {
			if (col[rowNo] == col[i] || rowNo - i == Math.abs(col[rowNo] - col[i]))
				return false;
		}
		return true;
	}

}