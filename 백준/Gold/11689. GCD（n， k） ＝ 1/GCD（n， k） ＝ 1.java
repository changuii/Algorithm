import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long answer = N;
        // 소수는 수의 제곱근까지만 존재
        for(long p = 2; p<= Math.sqrt(N); p++){
            // 현재 수로 N이 나누어 떨어지면
            if(N % p ==0){
                // 결과를 갱신
                answer = answer - (answer / p);
                while (N % p == 0){
                    N /= p;
                }
            }
        }

        if(N > 1) answer = answer - (answer / N);
        System.out.println(answer);


    }



}