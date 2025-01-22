import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> value = new ArrayList<>(map.keySet());
        value.sort((o1, o2) -> {
            return map.get(o2) - map.get(o1);
        });
        
        int answer = 0;
        for(int i=0; i< value.size(); i++){
            k -= map.get(value.get(i));
            answer++;
            if(k <= 0) return answer;
        }   
        
        return answer;
    }
}