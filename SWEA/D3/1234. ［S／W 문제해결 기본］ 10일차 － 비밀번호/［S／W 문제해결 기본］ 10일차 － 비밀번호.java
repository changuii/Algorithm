import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

// The main method must be in a class named "Main".
class Solution {
    static int win;
    static int lose;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            String M = st.nextToken();

            boolean flag = true;
            while (flag) {
                flag = false;
                for(int i=0; i<M.length()-1; i++){
                    if(M.charAt(i) == M.charAt(i+1)){
                        M = M.substring(0, i) + M.substring(i+2, M.length());
                        flag = true;
                    }
                }
            }
            
            sb.append(String.format("#%d %s\n", t, M));
        }
        System.out.println(sb);
    }
}