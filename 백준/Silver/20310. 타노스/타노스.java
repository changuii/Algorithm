import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();

        // S는 0의 개수와 1의 개수 모두 짝수
        // S' = 절반의 0 + 절반의 1
        // 사전순으로 가장 빠른 것 -> 0먼저 후 1
        
        int zero = x.replace("1", "").length() / 2;
        int one = x.replace("0", "").length() / 2;

        int l=x.length();
        int i=0;
        int j=0;
        int index = 0;
        char[] answer = new char[l/2];
        // 1. 0이라면 i가 zero 4보다 작을 때까지 추가한다.
        // 2. 1이라면 j가 one보다 크거나같을 때 까지 추가한다.
        for(int k = 0; k<l; k++){
            if(x.charAt(k) == '0'){
                if(i < zero) answer[index++] = x.charAt(k);
                i++;
            }else{
                if(j >= one) answer[index++] = x.charAt(k);
                j++;
            }
        }
        
        System.out.println(new String(answer));
        
    }
}