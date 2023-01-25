import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 392,196kb
// 1,396ms

public class Main_11728_배열_합치기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[] a = new int[N + M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            a[N + i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        for (int i = 0; i < N + M; i++)
            sb.append(a[i] + " ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
