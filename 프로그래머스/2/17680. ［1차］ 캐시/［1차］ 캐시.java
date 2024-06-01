import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String, Integer> cache = new HashMap<>();
        int time = 0;
        if(cacheSize == 0) return cities.length * 5;
        
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toLowerCase();
            if(cache.containsKey(city)){
                cache.put(city, i);
                time += 1;
            }else{
                if(cache.size() >= cacheSize){
                    String min = "min";
                    for(String key : cache.keySet()){
                        if(cache.getOrDefault(min, 100_001) > cache.get(key))
                            min = key;
                    }
                    cache.remove(min);
                }
                cache.put(city, i);
                time += 5;
            }
        }
        
        
        
        return time;
    }
}