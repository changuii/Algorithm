import java.util.*;

class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        
        String x = "";
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
            if(arr[i].length() > 1){
            arr[i] = arr[i].substring(0, 1).toUpperCase() 
                + arr[i].substring(1, arr[i].length()).toLowerCase();
            } else if (arr[i].length() > 0)
                arr[i] = arr[i].substring(0, 1).toUpperCase();
            x += arr[i] + " ";
        }
        if(s.charAt(s.length()-1) != x.charAt(x.length()-1))
            x= x.substring(0, x.length()-1);
        return x;
    }

}