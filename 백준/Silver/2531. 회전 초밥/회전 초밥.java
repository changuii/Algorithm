import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken())+1;
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] menu = new int[N];
        for(int i=0; i<N; i++){
            menu[i] = Integer.parseInt(br.readLine());
        }
        
        int answer = 0;
        for(int i=0; i<N; i++){
            boolean[] dish = new boolean[d];
            dish[c] = true;
            int count = 1;
            for(int j=i; j<i+k; j++){
                int index = menu[j % N];
                if(!dish[index]){
                    count++;
                    dish[index] = true;
                }
            }
            answer = Math.max(count, answer);
        }
        System.out.println(answer);
        
        
    }
}