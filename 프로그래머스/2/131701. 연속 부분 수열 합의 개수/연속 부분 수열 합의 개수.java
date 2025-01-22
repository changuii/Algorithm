import java.util.*;
class Solution {
    public int solution(int[] elements) {
        
        Set<Integer> count = new HashSet<>();
        
        for(int i=0; i<elements.length; i++){
            
            for(int j=0; j<elements.length; j++){
                int sum = 0;    
                for(int k=0; k<=i; k++){
                    sum += elements[(j + k) % elements.length];
                }
                count.add(sum);
            }
        }
        
        return count.size();
    }
}