import java.io.*;
import java.util.*;

// 12,424kb
// 120ms

public class Main_11866_요세푸스_문제_0 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        arr[0] = 1;
        sb.append("<");

        int p = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K; j++) {
                p = p % N + 1;
                if (arr[p] == 1) j--;
            }
            arr[p] = 1;
            sb.append(p + ", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
