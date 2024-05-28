import java.util.*;
class Solution {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0){
            list.add((int)(n%10));
            n/=10;
        }
        
        for(Integer s : list){
            System.out.println(s);
        }
        
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}