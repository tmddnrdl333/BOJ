import java.io.*;
import java.util.*;

// 18,184kb
// 224ms

public class Main_2890_카약 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        int[][] position = new int[R][2];

        for (int i = 0; i < R; i++) {
            char[] lane = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (Character.isDigit(lane[j])) {
                    position[lane[j] - '0'][0] = lane[j] - '0';
                    position[lane[j] - '0'][1] = j;
                    break;
                }
            }
        }

        Arrays.sort(position, (o1, o2) -> (o2[1] - o1[1]));

        int[] res = new int[9];
        int place = 1;
        res[position[0][0] - 1] = place;
        for (int i = 1; i < 9; i++) {
            if (position[i - 1][1] == position[i][1]) {
                res[position[i][0] - 1] = place;
            } else {
                res[position[i][0] - 1] = ++place;
            }
        }

        for (int i : res) sb.append(i + "\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

}