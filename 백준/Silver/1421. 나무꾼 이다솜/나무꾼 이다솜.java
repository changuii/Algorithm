import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        // n개의 나무, 자를 때 금액, 팔 때 금액

        int[] A = new int[N];
        int max = -1;
        // 나무 중 제일 긴 길이

        long ans = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(br.readLine());

            A[i] = next;
            max = Math.max(max, A[i]);
        } // 나무 길이를 입력받고 동시에 제일 긴 길이 찾기

        String len = "";
        for (int i = 1; i <= max; i++) {
            // 1~최대 길이까지 탐색
            long sum = 0;

            for (int j = 0; j < N; j++) {
                // 나무들 탐색
                int cnt = 0;
                if (A[j] >= i) {
                    // 현재 나무길이가, 탐색중인 길이보다 클 때
                    if (A[j] % i == 0) {
                        // 현재 나무 길이 / 탐색 길이의 나머지가 0이면
                        cnt = A[j] / i - 1; // 1을 빼줘야 자른 횟수가 나옴
                    } else
                        cnt = A[j] / i; // 그외엔 그대로

                    int temp = W * i * (A[j] / i) - cnt * C;
                    // 이번 나무 총 비용
                    // 비용 * 길이 * 나무 개수 - 자른 횟수 * 자를때 금액

                    if (temp > 0)
                        sum += temp;
                    // 총 비용이 +일때만 계산
                    // -라면 이번 나무 안팜
                }

            }

            if(sum > ans){
                ans = sum;
                len = i+"";
            }
            ans = Math.max(ans, sum);
            // 더 많은 수익이라면 갱신
        }

        
        System.out.print(ans);
    }

}