import java.io.*;
import java.util.*;

// 14,420kb
// 108ms

public class Main_2003_수들의_합_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int s = 0, e = 0;
        int sum = 0;
        int cnt = 0;
        while (s < N) {
            if (sum > M || e == N) sum -= arr[s++];
            else sum += arr[e++];

            if (sum == M) cnt++;
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();

    }

}