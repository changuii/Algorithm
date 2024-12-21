import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();

        System.out.println(numberOfWords(input));
    }

    private static int numberOfWords(final char[] input){
        int pointer = 0;
        int base = 0;

        while(base++ <= 30_000){
            char[] temp = String.valueOf(base).toCharArray();
            for(int i=0; i<temp.length; i++){
                if(temp[i] == input[pointer]){
                    pointer++;
                }
                if(input.length == pointer){
                    return base;
                }
            }
        }
        return base;
    }
}