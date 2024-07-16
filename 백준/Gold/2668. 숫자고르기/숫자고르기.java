import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] set = new int[N+1];
        
        nums = new int[N+1];
        for(int i=1; i<=N; i++){
            nums[i] = Integer.parseInt(br.readLine());
            set[nums[i]]++;
        }

        boolean[] visit = new boolean[N+1];
        for(int x=1; x<=N; x++){
            for(int i=1; i<=N; i++){
                if(visit[i]) continue;
                if(set[i] == 0){
                    visit[i] = true;
                    set[nums[i]]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=1; i<=N; i++){
            if(set[i] > 0){
                sb.append(i).append("\n");
                count++;
            }
        }
        sb.insert(0, count + "\n");
        System.out.println(sb);
        
    }


    
}