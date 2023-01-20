import java.io.*;
import java.util.*;

// 54,172kb
// 464ms

public class Main_1620_나는야포켓몬마스터이다솜 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        String[] arr = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            map.put(str, i);
            arr[i] = str;
        }
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (str.charAt(0) <= '9')
                sb.append(arr[Integer.parseInt(str)]).append("\n");
            else sb.append(map.get(str)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
