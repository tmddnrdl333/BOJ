import java.io.*;
import java.util.*;

// 13,012kb
// 104ms

public class Main_1004_어린_왕자 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    // 출발점과 도착점
    static int sx, sy, ex, ey;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (; T != 0; T--) {
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());

            int x = 0, y = 0, r = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                r = Integer.parseInt(st.nextToken());

                if (isDiff(x, y, r))
                    cnt++;
            }
            sb.append(cnt + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static boolean isDiff(int x, int y, int r) {
        // ds: 출발점과의 거리
        double ds = Math.sqrt(Math.pow(sx - x, 2) + Math.pow(sy - y, 2));
        // de: 도착점과의 거리
        double de = Math.sqrt(Math.pow(ex - x, 2) + Math.pow(ey - y, 2));

        // 해당 원에 대해 출발점과 도착점은 서로 다른 영역에 있는가? (진입/이탈이 필요한가?)
        if ((double) r < ds != (double) r < de) return true;
        return false;
    }

}
