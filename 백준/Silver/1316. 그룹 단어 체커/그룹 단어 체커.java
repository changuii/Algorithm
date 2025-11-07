import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0; i<N; i++) {
            char[] values = br.readLine().toCharArray();
            int[] visit = new int[26];
            boolean isGroup = true;

            for(int k=1; k<=values.length; k++) {
                if(visit[values[k-1] - 'a'] != 0 && Math.abs(visit[values[k-1] - 'a'] - k) > 1){
                    isGroup = false;
                    break;
                }

                visit[values[k-1] - 'a'] = k;
            }

            if(isGroup) answer++;
        }
        

        System.out.println(answer);
    }
}