import java.io.*;
import java.util.*;

// 38,864kb
// 296ms

public class Main_21921_블로그 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 1;
        int sum = 0;
        for (int i = 0; i < X; i++) sum += arr[i];
        int max = sum;

        for (int i = 0; i < N - X; i++) {
            sum = sum - arr[i] + arr[i + X];
            if (sum > max) {
                max = sum;
                cnt = 1;
            } else if (sum == max) {
                cnt++;
            }
        }

        if (max == 0) {
            bw.write("SAD");
        } else {
            bw.write(max + "\n" + cnt);
        }
        bw.flush();
        bw.close();
    }
}
