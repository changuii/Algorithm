import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static long[] tree;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());

       int k = 0;
       for(int i=0; i<N; i++){
           if(Math.pow(2, i) >= N) {
               k = i;
               break;
           }
       }

       tree = new long[(int) (Math.pow(2, k) * 2)];

       int start_index = (int) Math.pow(2, k);
       for(int i=0; i<N; i++){
           tree[start_index+i] = Long.parseLong(br.readLine());
       }

       for(int i=start_index-1; i>0; i--){
           tree[i] = tree[2 * i + 1] + tree[2 * i];
       }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M + K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1){
                chage( (int) (b + start_index - 1), c);
            }else if(a == 2){
                sb.append(rangeSum((int)(b + start_index - 1), (int) (c + start_index - 1))).append("\n");
            }

        }

        System.out.println(sb);


    }

    static void chage(int index, long value){

        tree[index] = value;

        int now = index;
        while (true){
            now = now % 2 == 1 ? (now-1) / 2 : now / 2;
            if(now <= 0) return ;
            tree[now] = tree[now * 2] + tree[now * 2 + 1];
        }
    }

    static long rangeSum(int start_index, int end_index){
        long rangeSum = 0;

        while (start_index <= end_index){
            if(start_index % 2 == 1) rangeSum += tree[start_index];
            if(end_index % 2 == 0) rangeSum += tree[end_index];

            start_index = (start_index + 1) /2;
            end_index = (end_index - 1) /2 ;
        }
        return rangeSum;

    }



}