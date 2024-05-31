import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        
        // i = length;
        int c = 0;
        for(int i=1; i<=elements.length; i++){
            for(int j=0; j<elements.length; j++){
                int sum = 0;
                for(int x=j; x<j+i; x++){
                    int index = x;
                    if(index >= elements.length) index %= elements.length;
                    sum += elements[index]; 
                }
                if(!set.contains(sum)){
                    set.add(sum);
                    c++;
                }
            }
        }
        return c;
    }
}