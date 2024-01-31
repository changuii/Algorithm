import java.io.IOException;
import java.util.*;


class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        long start = 1;
        long end = K;
        long ans = 0;

        while (start <= end){
            // start와 end의 중앙 인덱스
            long middle = (start + end) / 2;
            long cnt = 0;

            // N과 중앙 인덱스 중 낮은 값
            for(int i = 1; i<=N; i++){
                cnt += Math.min(middle/i, N);
            }

            // 중앙 인덱스보다 작은 값이 K보다 작다면 시작 인덱스를 중앙값 +1로 설정
            if(cnt < K){
                start = middle +1;
                // 그렇지 않다면 ans를 middle로 두고 end값을 middle-1로 설정
                // 이때 end가 start보다 작아진다면 정답 == 작은 수의 개수가 k-1개인 중앙값이 정답
            }else{
                ans = middle;
                end = middle -1;
            }
        }

        System.out.println(ans);

    }
}