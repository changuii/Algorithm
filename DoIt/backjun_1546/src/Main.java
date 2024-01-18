import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /* 내가 푼 부분
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        float high = 0;
        float value = 0;
        float[] num = new float[N];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            if(high < num[i]) high = num[i];
        }
        for(int i=0; i<N; i++){
            value += num[i]/high*100;
        }
        System.out.println(value/N);
         */
        /* 책에서 제공한 풀이 + 내 풀이 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());
            if(max < value) max = value;
            sum += value;
        }
        System.out.println( sum*100.0/max/N);


    }
}