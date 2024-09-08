import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
     public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int test=1; test<=T; test++){

            int N = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new int[]{a, b});
            }
            Collections.sort(list, (o1, o2)->{
               return o1[0] - o2[0]; 
            });

            int cnt = 0;
            for(int i=0; i<list.size(); i++){
                int[] now = list.get(i);
                for(int j=i+1; j<list.size(); j++){
                    if(now[1] > list.get(j)[1]){
                        cnt++;
                    }
                }
            }
            
            sb.append("#").append(test).append(" ")
                .append(cnt);
            if(test != T) sb.append("\n");
            
        }
        System.out.println(sb);
    }

    
}