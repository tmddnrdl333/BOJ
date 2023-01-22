import java.io.*;
import java.util.*;

// 12,424kb
// 120ms

public class Main_5596_시험_점수 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < 4; i++)
            sum1 += Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            sum2 += Integer.parseInt(st.nextToken());
        bw.write(sum1 > sum2 ? sum1 + "" : sum2 + "");
        bw.flush();
        bw.close();
    }
}
