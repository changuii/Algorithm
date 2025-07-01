import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    static List<Integer> val;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        val = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            val.add(Integer.parseInt(st.nextToken()));
        }

        int x = 0;
        int y = 0;
        int min = 2_000_000_001;

        Collections.sort(val);
        for(int i=0; i<N; i++){
            int now = binarySearch(i);
            for(int j=now-2; j<=now+1; j++){
                if(j < 0 || j >= N || i == j) continue;

                int v = Math.abs(val.get(j) + val.get(i));
                if(v < min){
                    x = i;
                    y= j;
                    min = v;
                }
            }
        }

        System.out.println(val.get(x) + " " + val.get(y));
    }
    
    public static int binarySearch(int target){
        int l = target + 1;
        int h = val.size() - 1;

        int mid = 0;
        while(l <= h){ // 여기
            mid = (l + h) / 2;

            if(val.get(mid) < val.get(target) * -1){ // 여기
                l = mid + 1; // 여기
            } else {
                h = mid - 1; // 여기
            }
        }
        
        return l; // 여기
    }
        // 3가지 경우의 수 
        // l mid h일때, 1이 답인경우, 2가 답인 경우, 3이 답인 경우를 시뮬레이션해서 맞는지 확인 
        // 1 2 3
        //
}