import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> feeMap = new HashMap<>();
        final int MAX_TIME = 1439;
        
        int time;
        for(int i=records.length-1; i>=0; i--){
            String val = records[i];
            String[] now = val.split(" ");
            String[] times = now[0].split(":");
            int nowTime = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            int outTime = 0;
            if(now[2].equals("IN")){
                if(map.containsKey(now[1])){
                    outTime = map.get(now[1]);
                    map.remove(now[1]);
                }else{
                    outTime = MAX_TIME;
                }
                int parkingTime = outTime - nowTime;
                feeMap.put(now[1], feeMap.getOrDefault(now[1], 0) + parkingTime);
            }else{
                map.put(now[1], nowTime);
            }
            
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for(String key : feeMap.keySet()){
            list.add(new int[]{Integer.parseInt(key), 
              feeMap.get(key) <= fees[0] ? fees[1] 
                  : (int) Math.ceil((feeMap.get(key) - fees[0]) / (float) fees[2]) * fees[3] + fees[1]});
        }
        
        Collections.sort(list, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i)[1];
        }
        
        return answer;
    }
}