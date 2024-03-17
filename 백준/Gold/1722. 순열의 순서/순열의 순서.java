import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[] V = new boolean[N+1];
        long[] A = new long[N+1];
        A[0] = 1;
        for(int i=1; i<N+1; i++){
            A[i] = A[i-1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        if(st.nextToken().equals("1")){
            long th = Long.parseLong(st.nextToken()) - 1;
            for(int i=N; i > 0; i--){
                long ith = th / A[i-1] + 1;
                th %= A[i-1]; // th를 갱신
                long count = 0; // 카운트하면서 ith번째 수를 찾는다.
                int index = 0; // ith번째 수가 몇인지 찾는다.
                while (count != ith){ // 만약 ith번째 숫자까지 왔다면 반복을 종료한다.
                    index++; // 1 ~ N까지 돌면서 ith번째 수를 찾는다.
                    if(!V[index]) count++; // 남아있는 숫자라면 카운트한다.
                }
                V[index] = true;
                sb.append(index).append(" ");
            }
        }else{
            long th = 1;
            for(int i=N; i>0; i--){
                int data = Integer.parseInt(st.nextToken());
                int index = 0;
                int count = 0;
                while (index != data){
                    index++;
                    if(!V[index]) count++;
                }
                V[index] = true;
                th += (count-1) * A[i-1];
            }
            sb.append(th);
        }

        System.out.println(sb);


    }

}