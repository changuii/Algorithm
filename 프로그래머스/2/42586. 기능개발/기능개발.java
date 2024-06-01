import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        List<Integer> list = new ArrayList<>();
        int index = 0;
        
        int[] day = new int[progresses.length];
        for(int i=0; i<day.length; i++){
            day[i] = (int) Math.ceil((double)(100 - progresses[i]) / (double)speeds[i]);
        }
        
        int max = day[0];
        int c = 1;
        for(int i=1; i<day.length; i++){
            if(max < day[i]){
                list.add(c);
                c = 1;
                max = day[i];
            }else c++;
        }
        list.add(c);  
        
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}