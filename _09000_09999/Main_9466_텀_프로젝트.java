package ps.BOJ._09000_09999;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 302,324kb
// 1,092ms

public class Main_9466_텀_프로젝트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int n;
	static int[] arr;
	static boolean[] visited, done;
	static int[] loop;
	static int res;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			done = new boolean[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			res = 0;
			for (int i = 1; i <= n; i++) {
				if (done[i])
					continue;
				dfs(i);
			}
			sb.append(n - res + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void dfs(int i) {
		if (done[i])
			return;
		// 루프 멤버이다. 이번에 다시 돌 땐 done에 체크하면서 res++
		if (visited[i]) {
			done[i] = true;
			res++;
		}
		visited[i] = true;
		dfs(arr[i]);
		done[i] = true; // 루프 멤버는 아니지만 다음에 다시 보지 말자.
//		visited[i] = false; // 사실 이번에 돌았던 애들 중에 루프였던 애들도 아니었던 애들도 다 done 표시 해줬기 때문에 다시 볼 일 없다.
	}
}