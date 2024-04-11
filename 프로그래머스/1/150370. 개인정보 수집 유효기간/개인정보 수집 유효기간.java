import java.util.*;

class Solution {
    
    StringTokenizer nowDateTime;
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for(String value : terms){
            StringTokenizer st = new StringTokenizer(value, " ");
            map.put(st.nextToken(), Integer.parseInt(st.nextToken()) * 28);
        }
        
        
        
        List<Integer> A = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            nowDateTime = new StringTokenizer(today, ".");
            StringTokenizer st = new StringTokenizer(privacies[i], " ");
            int x = dateTimeToDay(st.nextToken());
            x += map.get(st.nextToken());
            if(x <= 0) A.add(i+1);
        }
        
        int[] answer = new int[A.size()];
        for(int i=0; i<A.size(); i++){
            answer[i] = A.get(i);
        }
        return answer;
    }
    
    public int dateTimeToDay(String dateTime){
        StringTokenizer st = new StringTokenizer(dateTime, ".");
        
        int value = 0;
        value += ((Integer.parseInt(st.nextToken()) 
                  - Integer.parseInt(nowDateTime.nextToken())) * 12 * 28);
        
        value += ((Integer.parseInt(st.nextToken())
                  - Integer.parseInt(nowDateTime.nextToken())) * 28);
        
        value += ((Integer.parseInt(st.nextToken())
                  - Integer.parseInt(nowDateTime.nextToken())));
        
        return value;
    } 
}