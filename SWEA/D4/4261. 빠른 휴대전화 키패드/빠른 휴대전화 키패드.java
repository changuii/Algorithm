import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        Set<Character>[] set = new HashSet[10];
        for(int i=2; i<10; i++){
            set[i] = new HashSet<>();
        }

        set[2].addAll(Arrays.asList(new Character[]{'a', 'b', 'c'}));
        set[3].addAll(Arrays.asList(new Character[]{'d', 'e', 'f'}));
        set[4].addAll(Arrays.asList(new Character[]{'g', 'h', 'i'}));
        set[5].addAll(Arrays.asList(new Character[]{'j', 'k', 'l'}));
        set[6].addAll(Arrays.asList(new Character[]{'m', 'n', 'o'}));
        set[7].addAll(Arrays.asList(new Character[]{'p', 'q', 'r', 's'}));
        set[8].addAll(Arrays.asList(new Character[]{'t', 'u', 'v'}));
        set[9].addAll(Arrays.asList(new Character[]{'w', 'x', 'y', 'z'}));
        

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int test=1; test<=T; test++){
            st = new StringTokenizer(br.readLine());

            char[] val = st.nextToken().toCharArray();
            int cnt = Integer.parseInt(st.nextToken());
            int answer = cnt;
            
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<cnt; i++){
                char[] now = st.nextToken().toCharArray();
                if(now.length != val.length){
                    answer--;
                    continue;
                } 

                for(int j=0; j<now.length; j++){
                    if(!set[val[j] - '0'].contains(now[j])){
                        answer--;
                        break;
                    }
                }
            }

            sb.append("#").append(test).append(" ")
                .append(answer).append("\n");
            
        }
        System.out.println(sb);


        
    }
}