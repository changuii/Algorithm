import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /* 내가 푼 풀이 */
        /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = Integer.parseInt(st.nextToken());
        int testcase = Integer.parseInt(st.nextToken());
        int[] sumArray = new int[size];
        st = new StringTokenizer(br.readLine(), " ");
        sumArray[0] = Integer.parseInt(st.nextToken());

        for(int i=1; i<size; i++){
            sumArray[i] = sumArray[i-1] + Integer.parseInt(st.nextToken());;
        }

        for(int i=0; i<testcase; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            if(start == 0){
                System.out.println(sumArray[Integer.parseInt(st.nextToken())-1]);
            }else{
                System.out.println(sumArray[Integer.parseInt(st.nextToken())-1]-sumArray[--start]);
            }
        }*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int test = Integer.parseInt(st.nextToken());
        long[] S = new long[size+1];
        st = new StringTokenizer(br.readLine(), " ");
        // 베열을 초기화하지 않으면 0이 들어가나?
        for(int i=1; i<size+1; i++){
            S[i] = S[i-1] + Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<test; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println( S[end] - S[start-1] );
        }


    }
}