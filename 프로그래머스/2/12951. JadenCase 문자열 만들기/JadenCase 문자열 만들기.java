import java.util.*;

class Solution {
    public String solution(String s) {
        String[] value = s.toLowerCase().split("");
        String answer = "";
        boolean flag = true;
        for(String v : value){
            answer += flag ? v.toUpperCase() : v;
            flag = v.equals(" ");
        }
        return answer;
    }

}