import java.io.*;
import java.util.StringTokenizer;

// 15,088kb
// 264ms

public class Main_1940_주몽 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for (int s = 0; s < N; s++) {
            int e = s + 1;

            while (e < N) {
                int cur = arr[s] + arr[e++];
                if (cur == M) {
                    cnt++;
                    break;
                }
            }
        }

        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}