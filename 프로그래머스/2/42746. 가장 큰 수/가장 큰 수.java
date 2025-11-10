import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
        }
        
        Collections.sort(list, (o1, o2) -> {
            return (o1 + o2).compareTo(o2 + o1) * -1;
        });
        
        if(list.get(0).equals("0")) return "0";
        
        
        return String.join("", list);
        
    }
}