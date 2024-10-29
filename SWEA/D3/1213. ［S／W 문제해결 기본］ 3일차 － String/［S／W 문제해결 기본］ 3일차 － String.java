import java.util.*;
import java.util.regex.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            int round = Integer.parseInt(br.readLine());

            int result = 0;
            String patternText = br.readLine();
            Pattern pattern = Pattern.compile(patternText);

            String input = br.readLine();
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                result++;
            }

            sb.append(String.format("#%d %d\n", round, result));
        }
        System.out.println(sb);
    }
}