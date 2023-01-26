import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 11,884kb
// 84ms

public class Main_2161_카드_1 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++)
            q.add(i);

        while (true) {
            int t = q.poll();
            sb.append(t + " ");

            if (q.isEmpty()) {
                break;
            }

            int b = q.poll();
            q.add(b);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
