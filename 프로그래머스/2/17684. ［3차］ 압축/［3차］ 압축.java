import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        
        for(int i=0; i<26; i++){
            dict.put((char)('A'+i)+"", i+1);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        int x = 0;
        int index = 27;
        for(int i=0; i<msg.length();){
            boolean flag = false;
            for(int j=i+1; j<=msg.length(); j++){
                if(!dict.containsKey(msg.substring(i, j))){
                    dict.put(msg.substring(i, j), index++);
                    list.add(dict.get(msg.substring(i, j-1)));
                    i += j-i-1;
                    flag = true;
                }
            }
            if(!flag){
                list.add(dict.get(msg.substring(i, msg.length())));
                break;
            }
        }
        
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}