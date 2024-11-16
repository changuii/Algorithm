import java.util.*;
import java.lang.*;
import java.io.*;


// The main method must be in a class named "Main".
class Solution {
    static List<Integer> list;
    static Set<Integer> set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            int N = 7;

            st = new StringTokenizer(br.readLine());
            int[] A = new int[N];

            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            sb.append(String.format("#%d %d\n", t, solution(A)));
        }
        System.out.println(sb);
    }

    public static int solution(int[] A){
        list = new ArrayList<>();
        set = new HashSet<>();

        DFS(A, new boolean[7], 0, 0, 0);

        int answer = 0;
        Collections.sort(list, (o1, o2)->o2-o1);
        // System.out.println(list);
        return list.get(4);
        
    }

    public static void DFS(int[] A, boolean[] visit, int now, int depth, int sum){
        if(depth == 3){
            if(!set.contains(sum)){
                list.add(sum);
                set.add(sum);
            }            
            return;
        }

        for(int i = now; i<A.length; i++){
            if(!visit[i]){
                visit[i] = true;
                DFS(A, visit, i, depth + 1, sum + A[i]);
                visit[i] = false;
            }
        }

        
        
    }
}