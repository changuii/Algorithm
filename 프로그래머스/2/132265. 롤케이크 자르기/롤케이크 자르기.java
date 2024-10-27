import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int count = 0;
        
        int[] left = new int[1_000_001];
        Set<Integer> leftSet = new HashSet<>();
        
        int[] right = new int[1_000_001];
        Set<Integer> rightSet = new HashSet<>();
        
        for(int i=0; i<topping.length; i++){
            right[topping[i]]++;
            rightSet.add(topping[i]);
        }
        
        for(int i=0; i<topping.length; i++){
            int now = topping[i];
            
            right[now]--;
            if(right[now] == 0){
                rightSet.remove(now);
            }
            
            left[now]++;
            leftSet.add(now);
            
            if(leftSet.size() == rightSet.size()){
                count++;
            }
        }
        return count;
    }
}