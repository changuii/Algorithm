import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int isPossible = (1 << 26) - 1;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] values = new String[N];
        for(int i=0; i<N; i++){
            values[i] = br.readLine();
        }

        dfs(values, 0, 0);
        System.out.println(answer);
    }

    public static void dfs(String[] values, int now, int visit){
        if(visit == isPossible){
            answer++;
        }

        for(int i=now; i<values.length; i++){
            dfs(values, i+1, calculateVisit(values[i], visit));
        }
        
    }

    public static int calculateVisit(String value, int visit){
        char[] v = value.toCharArray();
        for(int i=0; i < v.length; i++){
            int c = v[i] - 'a';
            visit = visit | (1 << c);
        }
        return visit;
    }
}