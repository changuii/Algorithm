import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wanted = new HashMap<>();
        
        int c = 0;
        // init want
        for(int i=0; i<want.length; i++){
            wanted.put(want[i], number[i]);
        }
        
        // init 1일 ~ 10일
        for(int i=0; i<10; i++){
            wanted.put(discount[i], wanted.getOrDefault(discount[i], 0) - 1);
        }
        
        boolean flag = false;
        for(String x : want){
            if(wanted.get(x) > 0){
                flag = true;
                break;
            }
        }
        
        // 1일에 가입
        if(!flag) c++;
        
        // 2일 ~  => 1일 제거 후 10일 추가
        for(int i=10; i<discount.length; i++){
            wanted.put(discount[i-10], wanted.get(discount[i-10]) + 1);
            wanted.put(discount[i], wanted.getOrDefault(discount[i], 0) -1);
            
            flag = false;
            for(String x : want){
                if(wanted.get(x) > 0){
                    flag = true;
                    break;
                }
            }
            if(!flag) c++;
        }
        return c;
    }
}