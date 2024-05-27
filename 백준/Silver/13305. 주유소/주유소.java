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
        for(int i=1; i<N; i++){
            dist[i] = Integer.parseInt(st.nextToken());
        }

        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 현재 가격보다 싼 위치를 정한다.
        // 2. 해당 위치까지 가는 데 드는 비용만큼 주유한다.
        int answer = 0;
        for(int i=0; i<N-1; i++){
            int min = i;
            for(int j=i+1; j<N; j++){
                if(price[min] >= price[j]){
                    min = j;
                    break;
                }
            }
            int distance = 0;
            for(int j=i+1; j<N; j++){
                distance += dist[j];
                if(j == min) break;
            }
            answer += distance*price[i];
            i = min-1;
        }
        System.out.println(answer);
    }
}