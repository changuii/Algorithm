import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> nodes = new ArrayList<>();
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            nodes.add(new int[]{
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()), 0});
        }

        for(int i=0; i<nodes.size(); i++){
            int[] now = nodes.get(i);
            int count = 1;
            for(int j=0; j<nodes.size(); j++){
                int[] compare = nodes.get(j);
                if(now[1] <  compare[1] && now[0] < compare[0])
                    count++;
            }
            now[2] = count;
        }

        StringBuilder sb = new StringBuilder();
        for(int[] n : nodes){
            sb.append(n[2]).append(" ");
        }
        System.out.println(sb);
    }
}