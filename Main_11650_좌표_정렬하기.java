import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 73,032kb
// 760ms
public class Main_11650_좌표_정렬하기 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> (o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]));
        for (int i = 0; i < N; i++)
            sb.append(arr[i][0] + " " + arr[i][1] + "\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}