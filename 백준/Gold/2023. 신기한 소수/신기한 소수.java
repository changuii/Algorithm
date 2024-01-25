import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static int[] starts = { 2, 3, 5, 7 };
	static int[] additionals = { 1, 3,5, 7, 9 };
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		sb = new StringBuilder();
		dfs(0, 0);

		System.out.println(sb);

		br.close();
	}

	public static void dfs(int c, int x) {
		if (c == N) {
			sb.append(x).append("\n");
			return;
		}
		// 자리수 +1 
		x *= 10;
		
		// 가장 앞의 자리수라면 2, 3, 5, 7
		if (c == 0) {
			for (int n : starts) {
				int nx = x + n;
				if (isPrime(nx)) {
					dfs(c + 1, nx);
				}
			}
		// 나머지는 1, 3, 5, 7, 9
		} else {
			for (int n : additionals) {
				int nx = x + n;
				if (isPrime(nx)) {
					dfs(c + 1, nx);
				}
			}
		}
	}

	public static boolean isPrime(int x) {
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}
}