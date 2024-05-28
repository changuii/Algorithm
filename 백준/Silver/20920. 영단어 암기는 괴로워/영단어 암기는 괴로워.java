import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<N; i++){
            String value = br.readLine();
            if(value.length() < M) continue;
            map.put(value, map.getOrDefault(value, 0)+1);
        }

        List<String> answer = new ArrayList(map.keySet());
        Collections.sort(answer, (o1,o2)->{
            if(map.get(o1) != map.get(o2)) return map.get(o2)-map.get(o1);
            else if(o1.length() != o2.length()) return o2.length()-o1.length();
            else return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for(String x : answer){
            sb.append(x).append("\n");
        }
        System.out.println(sb);
        
    }
}