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

            // 스택이 비어있거나, 탑의 높이보다 현재가 클 경우
            if(q.isEmpty() || q.peekLast()[1] < now){
                q.addLast(new int[]{i, now});
                continue;
            }

            // 스택이 비어있지 않고, 탑의 값보다 현재 값이 작거나 같은 경우
            while(!q.isEmpty() && q.peekLast()[1] >= now){
                int[] before = q.pollLast();
                // 스택이 비어있는 경우 before의 높이는 before의 이전 높이들보다 작거나 같음 -> 따라서 0부터 시작하더라도 문제 없음
                // 스택이 비어있지 않은 경우 이전 값의 우측 좌표값이 길이가 됨
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