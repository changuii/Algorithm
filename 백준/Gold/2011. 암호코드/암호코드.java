import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String val = br.readLine();

        if(val.charAt(0) == '0'){
            System.out.println(0);
            return;
        }
        for(int i=1; i<val.length(); i++){
            if(val.charAt(i) == '0' && !(val.charAt(i-1) == '1' || val.charAt(i-1) == '2' )){
                System.out.println(0);
                return;
            }
        }
        
        int[] map = new int[100];
        makeMap(map);

        int[] dp = new int[val.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<dp.length; i++){
            String str1 = val.substring(i-1, i);
            String str2 = val.substring(i-2, i);
            dp[i] = dp[i-1] * map[Integer.parseInt(str1)] % 1000000;
            if(str2.charAt(0) != '0'){
                dp[i] += dp[i-2] * map[Integer.parseInt(str2)] % 1000000;
            }
        }
        
        System.out.println(dp[val.length()] % 1000000);
        
    }

    public static void makeMap(int[] map){
        for(int i=1; i<=26; i++){
            map[i] =1;
        }
        
    }

}