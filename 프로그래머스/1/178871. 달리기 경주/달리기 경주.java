import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] players, String[] callings) {
        for(String name : callings){
            if(!map.containsKey(name))
                search(players, name);
            else swap(players, map.get(name));
        }
        return players;
    }
    
    public void search(String[] players, String callName){
        int index = 0;
        for(int i=1; i<players.length; i++){
           if(players[i].equals(callName)){
               index = i;
               break;
           }
        }
        swap(players, index);
    }
    public void swap(String[] players, int index){
        map.put(players[index], index-1);
        map.put(players[index-1], index);
        String temp = players[index];
        players[index] = players[index-1];
        players[index-1] = temp;
    }
}