import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dist = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        // 거리의 누적합을 가격이 저렴한 구간이 나오기 전까지 구한다.
        long answer = 0;
        long now = Long.MAX_VALUE;
        for(int i=0; i<N; i++){
            now = Math.min(now, price[i]);
            answer += now*dist[i];
        }
        System.out.println(answer);
    }
}