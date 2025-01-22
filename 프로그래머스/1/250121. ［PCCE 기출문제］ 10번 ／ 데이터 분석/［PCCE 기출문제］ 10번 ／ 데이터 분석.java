import java.util.*;
import java.util.stream.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> map = initMap();
        
        int[][] answer = Arrays.stream(data)
            .filter(val -> val[map.get(ext)] < val_ext)
            .sorted((o1, o2) -> o1[map.get(sort_by)] - o2[map.get(sort_by)])
            .toArray(int[][]::new);
        
        return answer;
    }
    
    public Map<String, Integer> initMap(){
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        return map;
    }
}