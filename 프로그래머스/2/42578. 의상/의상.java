import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String[] v : clothes){
            map.put(v[1], map.getOrDefault(v[1], 0)+1);
        }
        
        int answer = 1;
        for(String x : map.keySet()){
            answer *= map.get(x)+1;
        }
        
        
        return answer -1;
    }
}