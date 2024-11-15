import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Map<String, Integer> map = init();
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            String input = br.readLine();
            st = new StringTokenizer(input.substring(1, input.length()));

            int test = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            
            String[] value = br.readLine().split(" ");
            
            String answer = Arrays.stream(value)
                .sorted((o1, o2) -> map.get(o1) - map.get(o2))
                .collect(Collectors.joining(" "));

            sb.append(String.format("#%d\n%s\n", test, answer));
        }
        System.out.println(sb);
    }

    public static Map<String, Integer> init(){
        Map<String, Integer> map = new HashMap<>();
        
        map.put("ZRO", 0);
        map.put("ONE", 1);
        map.put("TWO", 2);
        map.put("THR", 3);
        map.put("FOR", 4);
        map.put("FIV", 5);
        map.put("SIX", 6);
        map.put("SVN", 7);
        map.put("EGT", 8);
        map.put("NIN", 9);
        return map;
    }
}