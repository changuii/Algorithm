import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

class Solution {
    public String solution(String s) {
        List<Integer> list = Arrays.stream(s.split(" "))
            .map(i->Integer.parseInt(i))
            .collect(Collectors.toList());
        Collections.sort(list);
        
        
        return list.get(0) + " " + list.get(list.size()-1);
    }
}