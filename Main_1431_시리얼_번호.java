import java.io.*;
import java.util.*;

// 18,320kb
// 236ms

public class Main_1431_시리얼_번호 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) arr[i] = br.readLine();
        Arrays.sort(arr, (o1, o2) -> (o1.length() == o2.length() ? compareSum(o1, o2) == 0 ? o1.compareTo(o2) : compareSum(o1, o2) : o1.length() - o2.length()));
        for (int i = 0; i < N; i++) sb.append(arr[i] + "\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int compareSum(String o1, String o2) {
        char[] arr1 = o1.toCharArray();
        int sum1 = 0;
        for (char c : arr1) if (Character.isDigit(c)) sum1 += c - '0';
        char[] arr2 = o2.toCharArray();
        int sum2 = 0;
        for (char c : arr2) if (Character.isDigit(c)) sum2 += c - '0';
        return sum1 - sum2;
    }
}
