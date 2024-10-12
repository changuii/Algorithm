import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static Map<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = new int[M];
        for(int i=0; i<M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }


        ArrayList<Long> aList = new ArrayList<>();
        ArrayList<Long> bList = new ArrayList<>();
        for(int i=0; i<N; i++){
            makeList(A, aList, i, (long)A[i]);
        }
        for(int i=0; i<M; i++){
            makeList(B, bList, i, (long)B[i]);
        }

        // System.out.println(aList);
        // System.out.println(bList);
        long answer = 0;
        if(aList.size() > bList.size()){
            Collections.sort(aList);
            for(Long now : bList){
                if(map.containsKey(now)) answer += map.get(now);
                else{
                    long val = binarySearch(aList, now, T);
                    answer += val;
                    map.put(now, val);
                }
            }
        }
        else{
            Collections.sort(bList);
            for(Long now : aList){
                if(map.containsKey(now)) answer += map.get(now);
                else{
                    long val = binarySearch(bList, now, T);
                    answer += val;
                    map.put(now, val);
                }
            }
        }

        System.out.println(answer);
    }

    public static void makeList(int[] A, ArrayList<Long> list, int now, Long sum){
        list.add(sum);
        if(now >= A.length-1) return;
        
        makeList(A, list, now+1, sum + A[now+1]);
    }

    public static long binarySearch(ArrayList<Long> list, long sum, int T){
        int l = 0;
        int h = list.size() - 1;
        int mid = 0;

        while (l <= h) {
            mid = (l + h) / 2;

            if(list.get(mid) + sum <= T){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }

        long c = 0;
        for(int i= l-1; i>=0; i--){
            if(list.get(i) + sum == T){
                c++;
            }
            else break;
        }

        // if(c > 0) System.out.println(sum + " : "  + c);
        return c;
        
    }

}