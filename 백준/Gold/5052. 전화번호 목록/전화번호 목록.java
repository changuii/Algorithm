import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            
            List<String> list = new ArrayList<>();
            boolean isStartsWith = false;
            for(int i=0; i<N; i++){
                list.add(br.readLine());
            }
            Collections.sort(list);

            for(int i=0; i<N-1; i++) {
                String now = list.get(i);
                if(list.get(i+1).startsWith(now)) {
                        isStartsWith = true;
                        break;
                }
            }
            
            if(isStartsWith) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }
        

        System.out.println(sb);
    }
}