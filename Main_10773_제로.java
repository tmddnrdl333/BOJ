import java.io.*;
import java.util.Stack;

// 20,944kb
// 196ms

public class Main_10773_제로 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int inp = Integer.parseInt(br.readLine());
            if (inp == 0)
                sum -= stack.pop();
            else {
                stack.add(inp);
                sum += inp;
            }
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
