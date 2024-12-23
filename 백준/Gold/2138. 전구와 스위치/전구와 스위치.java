import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static char[] after;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String before = br.readLine();
        after = br.readLine().toCharArray();

        char[] firstOn = before.toCharArray();
        char[] firstOff = before.toCharArray();
        
        takeOn(firstOn, 0);
        int c1 = gridy(firstOn) + 1;
        int c2 = gridy(firstOff);
        
        boolean on = isEqualsArr(firstOn);
        boolean off = isEqualsArr(firstOff);

        if(!(on || off)){
            System.out.println(-1);
            return;
        }

        if(on && !off){
            System.out.println(c1);
            return;
        }

        System.out.println(c2);
    }

    public static int gridy(char[] value){
        int c = 0;
        for(int i=1; i<value.length; i++){
            if(value[i-1] != after[i-1]){
                takeOn(value, i);
                c++;
            }
        }
        return c;
    }

    public static void takeOn(char[] before, int index){
        if(index - 1 >= 0){
            before[index-1] = before[index-1] == '1' ? '0' : '1';
        }

        if(index + 1 < before.length){
            before[index+1] = before[index+1] == '1' ? '0' : '1';
        }

        before[index] = before[index] == '1' ? '0' : '1';
    }

    public static boolean isEqualsArr(char[] before){
        for(int i=0; i<before.length; i++){
            if(before[i] != after[i]) return false;
        }
        return true;
    }
}