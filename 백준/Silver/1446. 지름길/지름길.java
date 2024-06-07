import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int min = Integer.MAX_VALUE;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Shortcut> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(end - start > weight && end <= M) 
                list.add(new Shortcut(start, end, weight));
        }
        DFS(0, 0, list);
        System.out.println(min);
       
    }

    public static void DFS(int now, int sum, List<Shortcut> list){
        min = Math.min(M - now + sum, min);
        
        for(int i=0; i<list.size(); i++){
            if(list.get(i).start >= now){
                DFS(list.get(i).end, sum + list.get(i).weight + list.get(i).start - now,list);
            }
        }
        
    }

    static class Shortcut{
        int start;
        int end;
        int weight;
        Shortcut(int start, int end, int weight){
            this.start=start;
            this.end=end;
            this.weight=weight;
        }
        
    }
}