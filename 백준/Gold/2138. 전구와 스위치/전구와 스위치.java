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

        int c1 = 1;
        takeOn(firstOn, 0);
        for(int i=1; i<firstOn.length; i++){
            if(firstOn[i-1] != after[i-1]){
                takeOn(firstOn, i);
                c1++;
            }
            
            if(isEqualsArr(firstOn)){
                break;
            }
        }

        int c2 = 0;
        for(int i=1; i<firstOff.length; i++){
            if(firstOff[i-1] != after[i-1]){
                takeOn(firstOff, i);
                c2++;
            }

            if(isEqualsArr(firstOff)){
                break;
            }
        }

        boolean on = isEqualsArr(firstOn);
        boolean off = isEqualsArr(firstOff);

        if(!(on || off)){
            System.out.println(-1);
            return;
        }

        if(on && !off){
            System.out.println(c1);
        } else if(!on & off){
            System.out.println(c2);
        } else{
            System.out.println(c1 > c2 ? c2 : c1);
        }
    
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