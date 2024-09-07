import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        
        boolean[] isPrime = new boolean[1_000_001];
        for(int i=2; i<Math.sqrt(1_000_000); i++){
            for(int j=2; i*j<1_000_000; j++){
                isPrime[i * j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<1_000_000; i++){
            if(!isPrime[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);


        
    }
}