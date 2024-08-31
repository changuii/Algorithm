import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nickname = new HashMap<>();
        
        List<String[]> list = new ArrayList<>();
        for(String val : record){
            String[] now = val.split(" ");
            
            if(now[0].equals("Enter")){
                list.add(new String[]{now[1], "님이 들어왔습니다."});
                nickname.put(now[1], now[2]);
            }else if(now[0].equals("Leave")){
                list.add(new String[]{now[1], "님이 나갔습니다."});
            }else{
                nickname.put(now[1], now[2]);
            }
        }
        
        List<String> val = new ArrayList<>();
        for(String[] now : list){
            val.add(nickname.get(now[0]) + now[1]);
        }
        
        return val.toArray(new String[val.size()]);
    }
}