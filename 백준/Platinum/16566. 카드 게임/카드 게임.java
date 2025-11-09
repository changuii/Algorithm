import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] num;
    static boolean[] visit;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        num = new int[M];
        visit = new boolean[M];
        for(int i=0; i<M; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] c = new int[K];
        for(int i=0; i<K; i++){
            c[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<K; i++) {
            int idx = binarySearch(c[i]);

            int xidx = idx;
            for(int x=0; x+idx<num.length; x++) {
                if(!visit[x +idx]) {
                    xidx = x + idx;
                    visit[x+idx] = true;
                    break;
                }
            }
            sb.append(num[xidx]).append("\n");
        }
        System.out.println(sb);
        
    }


    // val = 4
    // 2 3 4 5 7 8 9
    // l = 0 h = 6 mid = 3
    // l = 0 h = 2 mid = 1
    // l = 2 h = 2 mid = 2
    // l = 3 h = 2 
    public static int binarySearch(int val) {
        int l = 0;
        int h = num.length - 1;

        int mid;
        while (l <= h) {
            mid = (l + h) / 2;

            if(check(mid, val)) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
            
        }

        return l;
    }

    public static boolean check(int mid, int val) {
        return val < num[mid];
    }
}