import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 12,176kb
// 178ms

public class Main_2695_공 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        int[][] inp = new int[T][2];
        int N = 0, K = 0;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            N = n > N ? n : N;
            K = k > K ? k : K;
            inp[i][0] = n;
            inp[i][1] = k;
        }

        // N: row, K: col
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][1] = i; // 금고가 1개인 모든 i층의 경우는 i 만큼의 횟수가 필요함.
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2; j <= K; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1);
                }
            }
        }

        for (int i = 0; i < T; i++) {
            sb.append(dp[inp[i][0]][inp[i][1]]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

}