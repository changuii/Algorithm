import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        
        // 0 -> 1, 1 -> 2, 2 -> 3
        // 3 -> 1
        int c = 0;
        char before = words[0].charAt(0);
        for(String x : words){
            if(set.contains(x) || before != x.charAt(0)){
                return new int[]{c % n + 1 , c / n + 1};
            }
            c++;
            before = x.charAt(x.length()-1);
            set.add(x);
        }
        
        return new int[]{0, 0};
    }
}