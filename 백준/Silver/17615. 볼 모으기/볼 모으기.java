import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] value = br.readLine().split("");

        boolean flag = false;
        int c1 = 0;
        for(int i=0; i<N; i++){
            if(flag){
                if(value[i].equals("R")) c1++;
            }
            else{
                if(value[i].equals("B")) flag = true;
            }
        }

        flag = false;
        int c2 = 0;
        for(int i=N-1; i>=0; i--){
            if(flag){
                if(value[i].equals("R")) c2++;
            }
            else{
                if(value[i].equals("B")) flag = true;
            }
        }

        flag = false;
        int c3 = 0;
        for(int i=0; i<N; i++){
            if(flag){
                if(value[i].equals("B")) c3++;
            }
            else{
                if(value[i].equals("R")) flag = true;
            }
        }

        flag = false;
        int c4 = 0;
        for(int i=N-1; i>=0; i--){
            if(flag){
                if(value[i].equals("B")) c4++;
            }
            else{
                if(value[i].equals("R")) flag = true;
            }
        }

        

        System.out.println(Math.min(c1, Math.min(c2, Math.min(c3, c4))));
    }
}