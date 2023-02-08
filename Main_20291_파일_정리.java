import java.io.*;
import java.util.*;

// 170,304kb
// 772ms

public class Main_20291_파일_정리 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String file = br.readLine();
            String str = file.substring(file.indexOf('.') + 1);
            int cnt = map.getOrDefault(str, 0);
            map.put(str, cnt + 1);
        }

        String[] res = new String[map.size()];
        int idx = 0;
        for (String str : map.keySet())
            res[idx++] = str + " " + map.get(str);

        Arrays.sort(res);

        for (String str : res)
            sb.append(str + "\n");
        sb.setLength(sb.length() - 1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
