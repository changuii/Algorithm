import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        for(int i=0 ;i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }


        radixSort(A, 5);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(A[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void radixSort(int[] A, int size){
        int[] out = new int[A.length];
        int c = 0;
        int now = 1;


        while(c != size){
            int[] bucket = new int[10];
            // 현재 자리수에 따라서 추가한다. ex) 101 -> bucket[1]++ / 7 -> bucket[7]++
            for(int i=0; i<A.length; i++){
                bucket[(A[i]/now)%10]++;
            }
            // 인덱스를 구하기 위해 합배열로 만든다. ex) bucket[0]=3 bucket[1]=1 -> 합배열[1] = 4 즉, 합배열1번 인덱스는 3부터 시작한다.
            for(int i=1; i<10; i++){
                bucket[i] += bucket[i-1];
            }
            // out[합배열-1]에 값을 추가하고 해당 인덱스를 --해준다.
            for(int i= A.length-1; i >= 0; i--){
                out[bucket[(A[i]/now) % 10]-1] = A[i];
                bucket[(A[i]/now)%10]--;
            }
            for(int i=0; i<A.length; i++){
                A[i] = out[i];
            }
            now *= 10;
            c++;
        }


    }
}