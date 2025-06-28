import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] val = br.readLine().toCharArray();

        if(N - M == 1){
            int max = 0;
            for(int i=0; i<N; i++){
                max = Math.max(max, val[i]);
            }
            System.out.println(((char) max) +"");
            return;
        }

        Deque<Character> q = new ArrayDeque<>();
        for(char v : val){

            while(M > 0 && !q.isEmpty() && q.peekLast() < v){
                q.pollLast();
                M--;
            }
            q.addLast(v);
        }

        for(int i=0; i<M; i++){
            q.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.pollFirst() + "");
        }
        
        System.out.println(sb);
    }
}