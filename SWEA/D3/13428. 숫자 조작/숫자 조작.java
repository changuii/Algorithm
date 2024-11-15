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

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            String value = br.readLine();
            char[] max = value.toCharArray();
            char[] min = value.toCharArray();
            min(min);
            max(max);

            sb.append(String.format("#%d %s %s\n", t, new String(min), new String(max)));
        }
        System.out.println(sb);
    }

    public static void max(char[] max){
        for(int i=0; i<max.length-1; i++){
            int val = i;
            for(int j=i+1; j<max.length; j++){
                if(max[i] - '0' < max[j] - '0' && max[val] - '0' <= max[j] - '0'){
                    val = j;
                }
            }
            if(val != i){
                char temp = max[val];
                max[val] = max[i];
                max[i] = temp;
                return;
            }
        }
    }

    public static void min(char[] min){
        for(int i=0; i<min.length-1; i++){
            int val = i;
            for(int j=i+1; j<min.length; j++){
                if(i == 0 && min[j] == '0') continue;
                if(min[i] - '0' > min[j] - '0' && min[val] - '0' >= min[j] - '0'){
                    val = j;
                }
            }
            if(val != i){
                char temp = min[val];
                min[val] = min[i];
                min[i] = temp;
                return;
            }
        }
    }
}