import java.io.*;
import java.util.Arrays;

// 26,456kb
// 280ms

public class Main_2217_로프 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int max = arr[0] * N;

        for (int i = 1; i < N; i++) {
            int tmp = arr[i] * (N - i);
            max = tmp > max ? tmp : max;
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
