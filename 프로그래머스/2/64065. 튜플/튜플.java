import java.util.*;
class Solution {
    public int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s.replaceAll("[{}]", ""), ",");
        
        Map<Integer, Integer> map = new HashMap<>();
        while(st.hasMoreTokens()){
            int key = Integer.parseInt(st.nextToken());
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        ArrayList<Integer> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr, (o1, o2)->{
           return map.get(o2) - map.get(o1); 
        });
        return arr.stream().mapToInt(i->i.intValue()).toArray();
    }
}