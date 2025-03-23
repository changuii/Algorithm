import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<int[]> q = new ArrayDeque<>();
        int max = 0;
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());

            if(q.isEmpty() || q.peekLast()[1] < now){
                q.addLast(new int[]{i, now});
                continue;
            }

            while(!q.isEmpty() && q.peekLast()[1] >= now){
                int[] before = q.pollLast();
                int size = q.size() == 0 ? i : i - (q.peekLast()[0] + 1);
                int result = before[1] * size;

                max = Math.max(max, result);
            }
            q.addLast(new int[]{i, now});
        }

        int i = N;
        while(!q.isEmpty()){
            int[] before = q.pollLast();
            int size = q.size() == 0 ? i : i - (q.peekLast()[0] + 1);
            int result = before[1] * size;

            max = Math.max(max, result);
        }
        

        System.out.println(max);
    }
}