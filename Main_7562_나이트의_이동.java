import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 61,076kb
// 268ms

public class Main_7562_나이트의_이동 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    static int l;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (; T > 0; T--) {
            l = Integer.parseInt(br.readLine());
            map = new int[l][l];

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            map[c][d] = 2;

            exec(a, b);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void exec(int a, int b) {
        int cnt = 0;

        if (map[a][b] == 2) {
            sb.append("0\n");
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        map[a][b] = 1;
        q.add(a * l + b);


        outer:
        while (!q.isEmpty()) {
            cnt++;
            int qSize = q.size();
            for (; qSize > 0; qSize--) {
                int idx = q.poll();
                int r = idx / l, c = idx % l;
                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d], nc = c + dc[d];
                    if (nr >= l || nc >= l || nr < 0 || nc < 0) continue;
                    if (map[nr][nc] == 1) continue;
                    if (map[nr][nc] == 2) break outer;

                    map[nr][nc] = 1;
                    q.add(nr * l + nc);
                }
            }
        }

        sb.append(cnt).append("\n");

    }
}