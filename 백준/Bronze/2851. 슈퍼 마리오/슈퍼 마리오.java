import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] values = new int[10];

        for(int i=0; i<10; i++){
            values[i] = Integer.parseInt(br.readLine());
        }


        int answer = 0;
        for(int i=9; i>=0; i--){
            int sum = values[i];

            for(int j=0; j<i; j++){
                sum += values[j];
            }

            if(Math.abs(100 - answer) > Math.abs(100 - sum) 
               || (Math.abs(100 - answer) == Math.abs(100 - sum) && sum > answer)){
                answer = sum;
            }
        }
        

        System.out.println(answer);
        
        
        
    }
}