import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] num;
    static int[] value;
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
        value = new int[M];
        for(int i=0; i<M; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            value[i] = i;
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

            int x = find(idx);
            union(x, x + 1);
            int xidx = x;
            
            sb.append(num[xidx]).append("\n");
        }
        System.out.println(sb);
        
    }

    public static int find(int a) {
        if(a == value[a]) return a;
        else return value[a] = find(value[a]);
    }

    public static void union(int a, int b) {
        if(a >= value.length || b >= value.length) return;
        
        int x = find(a);
        int y = find(b);

        if(x > y) {
            value[y] = x;
        }
        else {
            value[x] = y;
        }
    }

    
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