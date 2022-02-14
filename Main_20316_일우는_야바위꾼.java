package boj0214;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 37848kb
// 304ms

public class Main_20316_일우는_야바위꾼 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		@SuppressWarnings("unused")
		int N = Integer.parseInt(st.nextToken()); // 컵 수 (미사용)
		int X = Integer.parseInt(st.nextToken()); // 간식이 들어있는 컵
		int K = Integer.parseInt(st.nextToken()); // 이동 횟수
		// cups : index 1부터 cup의 상태를 나타내는 배열

		for (int i = 0; i < K; i++) {
			// 바꿀 컵 번호 a, b 입력받기
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 둘 다 간식이 든 X가 아니면 의미 없으므로 건너뛰기
			if (a != X && b != X)
				continue;
			// 둘 중 하나에 간식이 있다면 바꾸기
			X = a == X ? b : a;
		}
		// 결과 출력
		bw.write(X + "");
		bw.flush();
		bw.close();
	}
}
