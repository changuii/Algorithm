import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<N; i++){
            map.put(br.readLine(), 1);
            sum++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()){
                String now = st.nextToken();
                sum -= map.getOrDefault(now, 0);
                map.put(now, 0);
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
}