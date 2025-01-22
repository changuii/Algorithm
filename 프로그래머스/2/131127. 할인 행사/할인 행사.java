import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
        }
        
        for(int i=0; i<10; i++){
            if(!map.containsKey(discount[i])) continue;
            
            map.put(discount[i], map.get(discount[i]) - 1);
        }
        if(isAllProductDiscount(map)) answer++;
        
        int i = 0;
        int j = 10;
        
        while(j < discount.length){
            if(map.containsKey(discount[i])) map.put(discount[i], map.get(discount[i]) + 1);
            if(map.containsKey(discount[j])) map.put(discount[j], map.get(discount[j]) - 1);
            
            i++;
            j++;
            if(isAllProductDiscount(map)) answer++;
        }
        
        return answer;
    }
    
    public boolean isAllProductDiscount(Map<String, Integer> map){
        for(String k : map.keySet()){
            if(map.get(k) > 0) return false;
        }
        return true;
    }
}