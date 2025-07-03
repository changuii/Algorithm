import java.util.*;
import java.lang.*;
import java.io.*;

// https://www.acmicpc.net/problem/3079
class Main {
    static List<Long> list = new ArrayList<>();
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            list.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(list);

        System.out.println(binarySearch());
    }

    public static long binarySearch(){
        long l = 1;
        long h = Long.MAX_VALUE - 1;

        long mid;
        while(l <= h){
            mid = (l + h) / 2;

            if(!check(mid)){
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }

        return l;
    }

    // 1 2 3 -> 1 1 -> 1 0
    // 1 2 3 -> 1 1 -> 2 1
    // 1 2 3 -> 3 3 -> 3 2

    public static boolean check(long time){

        long sum = 0;
        for(int i=0; i<list.size() && sum < M; i++){
            sum += time / list.get(i);
        }

        return sum >= M;
    }
}