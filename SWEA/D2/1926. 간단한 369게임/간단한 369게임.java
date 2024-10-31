import java.util.*;
import java.util.stream.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static String[] dashs = {"", "-", "--", "---"};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        String answer = IntStream.range(1, N+1)
            .mapToObj(i -> toString(i))
            .collect(Collectors.joining(" "));

        sb.append(answer);
        System.out.println(sb);
    }

    public static String toString(int num){
        char[] value = String.valueOf(num).toCharArray();

        int c = 0;
        for(int i=0; i<value.length; i++){
            if(value[i] != '0' && (value[i] - '0') % 3 == 0){
                c++;
            }
        }

        if(c == 0){
            return String.valueOf(num);
        }
        return dashs[c];
    }
}