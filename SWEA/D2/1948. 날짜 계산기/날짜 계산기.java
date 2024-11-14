import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay =  Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            int answer = endDay + 1 + (days[startMonth] - startDay) + calculate(startMonth, endMonth);

            sb.append(String.format("#%d %d\n", t, startMonth == endMonth ? endDay - startDay + 1 : answer));            
        }
        System.out.println(sb);
    }

    public static int calculate(int start, int end){
        int sum = 0;
        for(int i=start+1; i<end; i++){
            sum += days[i];
        }
        return sum;
    }

}