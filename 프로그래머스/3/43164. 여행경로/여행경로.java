import java.util.*;
class Solution {
    Map<String, Integer> map = new HashMap<>();
    Map<Integer, String> reverseMap = new HashMap<>();
    boolean[][] visit = new boolean[10_000][10_000];
    ArrayList<ArrayList<Integer>> list;
    int N = 0;
    StringBuilder answer = new StringBuilder();
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        list = new ArrayList<>();
        for(int i=0; i<tickets.length; i++){
            String[] now = tickets[i];
            int index1 = map.getOrDefault(now[0], list.size());
            if(index1 == list.size()){
                map.put(now[0], index1);
                reverseMap.put(index1, now[0]);
                list.add(new ArrayList<>());
            }
            
            int index2 = map.getOrDefault(now[1], list.size());
            if(index2 == list.size()){
                map.put(now[1], index2);
                list.add(new ArrayList<>());
                reverseMap.put(index2, now[1]);
            }
            list.get(index1).add(index2);
        }
        
        for(int i=0; i<list.size(); i++){
            ArrayList<Integer> l = list.get(i);
            Collections.sort(l, (o1, o2)->{
                return reverseMap.get(o1).compareTo(reverseMap.get(o2));
            });
        }
        
        DFS(new StringBuilder("ICN "), map.get("ICN"), 0);
        return answer.toString().split(" ");
    }
    
    public void DFS(StringBuilder sb, int now, int depth){
        System.out.println(sb + " " + now);
        if(depth == N ){
            answer = sb;
            return;
        }
        ArrayList<Integer> l = list.get(now);
        for(int i=0; i<l.size() && answer.length() == 0; i++){
            if(!visit[now][i]){
                visit[now][i] = true;
                StringBuilder before = new StringBuilder(sb.toString());
                sb.append(reverseMap.get(l.get(i)) + " ");
                DFS(sb, l.get(i), depth+1);
                visit[now][i] = false;
                sb = before;
            }
        }
        
        
    }
}