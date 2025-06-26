import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static Map<String, String> map;
    static Map<String, Integer> count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){

            int N = Integer.parseInt(br.readLine());

            map = new HashMap<>();
            count = new HashMap<>();

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if(!map.containsKey(a)){
                    map.put(a, a);
                    count.put(a, 1);
                }
                if(!map.containsKey(b)){
                    map.put(b, b);
                    count.put(b, 1);
                }
                
                if(!find(a).equals(find(b))){
                    union(a, b);
                    sb.append(count.get(find(a))).append("\n");
                    continue;
                }
                sb.append(count.get(find(a))).append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void union(String a, String b){
        String x = find(a);
        String y = find(b);

        int c = count.get(x) + count.get(y);
        count.put(x, c);
        map.put(y, x);
    }

    public static String find(String a){
        if(map.get(a).equals(a)){
            return a;
        }
        String next = find(map.get(a));
        map.put(a, next);
        return next;
    }
        
    
}