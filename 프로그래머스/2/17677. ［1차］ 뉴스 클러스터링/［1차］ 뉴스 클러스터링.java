import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Map<String, Integer> set1 = new HashMap<>();
        Map<String, Integer> set2 = new HashMap<>();
        
        for(int i=0; i<str1.length()-1; i++){
            String now = str1.substring(i, i+2);
            if(now.charAt(0) < 'A' || now.charAt(0) > 'Z' 
               || now.charAt(1) < 'A' || now.charAt(1) > 'Z') continue;
            set1.put(now, set1.getOrDefault(now, 0) + 1);
        }
        for(int i=0; i<str2.length()-1; i++){
            String now = str2.substring(i, i+2);
            if(now.charAt(0) < 'A' || now.charAt(0) > 'Z' 
               || now.charAt(1) < 'A' || now.charAt(1) > 'Z') continue;
            set2.put(now, set2.getOrDefault(now, 0) + 1);
        }
        
        int interSize = 0;
        for(String s : set1.keySet()){
            if(set2.containsKey(s))
                interSize += Math.min(set1.get(s), set2.get(s));
        }
        
        int unionSize = 0;
        for(String s : set1.keySet()){
            if(set2.containsKey(s)){
                unionSize += Math.max(set1.get(s), set2.get(s));
                set2.remove(s);
            }else unionSize += set1.get(s);
        }
        for(String s : set2.keySet()){
            unionSize += set2.get(s);
        }
        
        
        System.out.println(interSize + " " + unionSize);
        if(unionSize == 0) return 65536;
        return (int) (((double) interSize / (double) unionSize) * 65536);
    }
}