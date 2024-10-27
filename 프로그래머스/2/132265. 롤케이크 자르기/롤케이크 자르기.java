import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int count = 0;
        
        int[] left = new int[10_001];
        int leftCount = 0;
        
        int[] right = new int[10_001];
        int rightCount = 0;
        
        for(int v : topping){
            if(right[v] == 0){
                rightCount++;
            }
            right[v]++;
        }
        
        for(int v : topping){
            right[v]--;
            if(right[v] == 0){
                rightCount--;
            }
            
            if(left[v] == 0){
                leftCount++;
            }
            left[v]++;
            
            if(leftCount == rightCount){
                count++;
            }
        }
        
        return count;
    }
}