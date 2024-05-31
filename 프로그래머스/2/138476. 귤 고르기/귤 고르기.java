import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        Integer[] s = map.keySet().toArray(new Integer[0]);
        Arrays.sort(s, (o1, o2) -> {
           return map.get(o2) - map.get(o1); 
        });
        
        int c = 0;
        for(int x : s){
            k -= map.get(x);
            c++;
            if(k <= 0) return c;
        }
        
        
        return c;
    }
}