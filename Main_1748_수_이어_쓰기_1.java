import java.io.*;

// 11,524kb
// 76ms

public class Main_1748_수_이어_쓰기_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int res = 0;

        for (int i = 1; i <= 9; i++) {
            if (N / (int) Math.pow(10, i) > 0) {
                res += ((int) Math.pow(10, i) - (int) Math.pow(10, i - 1)) * i;
            } else {
                res += (N - (int) Math.pow(10, i - 1) + 1) * i;
                break;
            }
        }


        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}
