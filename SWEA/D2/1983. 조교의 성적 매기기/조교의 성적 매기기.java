import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String[] rank = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int point = N / 10;
            List<Node> list = new ArrayList<>();

            for(int i=0; i<N; i++){
                double score = calculate(st, br);
                list.add(new Node(score));
            }

            Node target = list.get(M-1);

            Collections.sort(list, (o1, o2)->{
               return Double.compare(o1.score, o2.score) * -1; 
            });

            int index = 0;
            for(int i=0; i<N; i++){
                list.get(i).rank = index;
                if((i+1) % point == 0){
                    index++;
                }
            }

            sb.append(String.format("#%d %s\n", t, rank[target.rank]));
        }
        System.out.println(sb);
        
    }

    public static class Node{
        double score;
        int rank;
        public Node(double score){
            this.score = score;
        }
    }

    public static double calculate(StringTokenizer st, BufferedReader br) throws Exception{
        st = new StringTokenizer(br.readLine());
        double a = Integer.parseInt(st.nextToken()) * 0.35;
        double b = Integer.parseInt(st.nextToken()) * 0.45;
        double c = Integer.parseInt(st.nextToken()) * 0.2;

        return a + b + c;
    }
}