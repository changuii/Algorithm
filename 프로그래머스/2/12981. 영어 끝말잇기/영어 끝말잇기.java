import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        
        int round = -1;
        Set<String> set = new HashSet<>();
        char before = words[0].charAt(0);
        
        for(String word : words){
            round++;
            
            if(set.contains(word) || before != word.charAt(0)){
                System.out.println(word);
                return new int[]{round % n + 1, (round + n) / n};
            }
            
            before = word.charAt(word.length()-1);
            set.add(word);
        }
        

        return new int[]{0, 0};
    }
}