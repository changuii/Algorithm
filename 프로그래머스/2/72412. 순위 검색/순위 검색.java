import java.util.*;
class Solution {
    static String[][] info;
    static Map<String, List<Integer>> map;
    public int[] solution(String[] info, String[] query) {
        
        map = new HashMap<>();
        this.info = new String[info.length][5];
        for(int i=0; i<info.length; i++) {
            this.info[i] = info[i].split(" ");
            add(this.info[i][0], this.info[i][1], this.info[i][2], this.info[i][3], this.info[i][4]);
        }
        
        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        
        
        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++) {
            String[] q = query[i].split(" ");
            
            String lang = q[0];
            String type = q[2];
            String year = q[4];
            String food = q[6];
            String score = q[7];   
            answer[i] = query(lang, type, year, food, score);
        }
        return answer;
    }
    
    public int query(String lang, String type, String year, String food, String score) {
        int c =0;
        
        int s = Integer.parseInt(score);
        List<Integer> list = map.get(lang + type + year + food);
        if(list == null) return 0;
        
        int idx = binarySearch(list, s);
        
        return list.size() - idx;
    }
    
    // 1 2 3 v 1
    // 1 3 -> 1 1 -> 0 -1
    // 1 2 3 v 2
    // 1 3 -> 1 1 -> 1 0
    // 1 2 3 v 3
    // 1 3 -> 3 3 -> 2 1
    
    public int binarySearch(List<Integer> list, int value) {
        int l = 0;
        int h = list.size() - 1;
        
        int mid;
        while(l <= h) {
            mid = (l + h) / 2;
            
            if(list.get(mid) >= value) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        
        return l;
    }
    
    
    public void add(String lang, String type, String year, String food, String score) {
        String all = "-";
        int sc = Integer.parseInt(score);
        
        for(int i=0; i<2; i++) {
            String key = i == 0 ? lang : all;
            for(int j=0; j<2; j++) {
                String key1 = j == 0 ? key + type : key + all;
                for(int k=0; k<2; k++) {
                    String key2 = k == 0 ? key1 + year : key1 + all;
                    for(int x=0; x<2; x++) {
                        String key3 = x == 0 ? key2 + food : key2 + all;
                        
                        if(map.containsKey(key3)) {
                            map.get(key3).add(sc);
                        }
                        else {
                            List<Integer> list = new ArrayList<>();
                            list.add(sc);
                            map.put(key3, list);
                        }
                    }
                }
            }
        }
    }
    
    
}