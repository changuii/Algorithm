import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String val = br.readLine();

        if(N - M == 1){
            int max = 0;
            for(int i=0; i<N; i++){
                max = Math.max(max, val.charAt(i));
            }
            System.out.println(((char) max) +"");
            return;
        }

        StringBuilder sb = new StringBuilder(val);
        int now = 0;
        for(int i=0; i<M; i++){

            boolean flag = false;
            for(int j=now; j<sb.length()-1; j++){
                if(sb.charAt(j) < sb.charAt(j+1)){
                    sb.deleteCharAt(j);
                    now = j == 0 ? 0 : j-1;
                    flag = true;
                    break;
                }
            }

            if(!flag){
                sb.deleteCharAt(sb.length()-1);
            }
        }
        
        System.out.println(sb);
        
    }
}