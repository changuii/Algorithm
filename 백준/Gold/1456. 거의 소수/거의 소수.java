import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        // 100,000,000,000,000 -> (10,000,000)^2 즉 천만의 제곱까지만 구하면 거의 소수를 구할 수 있다.
        boolean[] X = new boolean[10000001];
        for(int i=2; i<Math.sqrt(X.length); i++){
            if(!X[i]) {
                for (int j = i + i; j < X.length; j += i) {
                    X[j] = true;
                }
            }
        }

        // 거의 소수 -> A와 B사이에 있고 소수의 제곱인 수
        // 수가 크기때문에 수를 단순화 시킨다.
        // N^k <= B -> N <= B / N^k-1
        // N^k >= A -> N >= A / N^k-1
        int answer = 0;
        for (int i = 2; i < X.length; i++) {
            if (!X[i]) {
                long now = i;
                while ((double) i <= (double) B / (double) now) {
                    if ((double) i >= (double) A / (double) now) {
                        answer++;
                    }
                    now *= i;
                }
            }
        }
        System.out.println(answer);


    }



}