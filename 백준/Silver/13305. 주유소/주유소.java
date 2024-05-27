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
        price[0] = Integer.parseInt(st.nextToken());
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i=1; i<N; i++){
            price[i] = Integer.parseInt(st.nextToken());
            if(price[i] <= price[i-1] || i == N-1){
                arr.add(new int[]{price[i-1], dist[i-1]});
            }else{
                price[i] = price[i-1];
                dist[i] = dist[i-1] + dist[i];
            }
        }

        // 거리의 누적합을 가격이 저렴한 구간이 나오기 전까지 구한다.
        // 
        // 1. 현재 가격보다 싼 위치를 정한다.
        // 2. 해당 위치까지 가는 데 드는 비용만큼 주유한다.
        int answer = 0;
        for(int[] x : arr){
            answer += x[0] * x[1];
        }
        System.out.println(answer);
    }
}