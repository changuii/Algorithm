import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] A = new int[N];
        int[] S = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            S[i] = A[i];
        }
        Arrays.sort(S);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(S[0], 0);
        int c = 0;
        for(int i=1; i<N; i++){
            if(S[i-1] == S[i]){
                c++;
                continue;
            } 
            map.put(S[i], i - c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(map.get(A[i])).append(" ");
        }
        System.out.println(sb);
    }
}