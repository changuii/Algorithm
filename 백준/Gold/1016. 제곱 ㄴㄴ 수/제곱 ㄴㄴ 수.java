import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Long S = Long.parseLong(st.nextToken());
        Long E = Long.parseLong(st.nextToken());
        
        // 구간의 크기만큼 배열 할당
        boolean[] A = new boolean[(int) (E - S + 1)];

        // 제곱수가 E를 벗어나지는 않는지 체크
        for(long i = 2; i * i <= E; i++){
            long pow = i * i;
            // S = 20, i = 2 : start_index = 5
            long start_index = S / pow;
            // 나머지가 있다면 +1
            if(S % pow != 0)
                start_index++;
            for(long j = start_index; pow * j <= E; j++){
                // j * pow를 하면서 값을 찾아서 true로 바꾼다.
                A[(int) ((j*pow) - S)] = true;
            }

        }

        int answer = 0;
        for(int i=0; i<= E - S; i++){
            if(!A[i]) answer++;
        }

        System.out.println(answer);


    }



}