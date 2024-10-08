import java.util.*;
class Solution {
    public int solution(String[][] relation) {
        return BFS(relation);
    }
    
    public int BFS(String[][] relation){
        int cnt = 0;
        ArrayDeque<List<Integer>> q = new ArrayDeque<>();
        Set<int[]>[] isSubSet = new Set[relation[0].length];
        for(int i=0; i<relation[0].length; i++){
            isSubSet[i] = new HashSet<>();
            List<Integer> l = new ArrayList<>();
            l.add(i);
            q.addLast(l);
        }
        while(!q.isEmpty()){
            // 0 1, 02, 0 3
            List<Integer> now = q.poll();
            
            int size = now.size()-2;
            boolean flag = false;
            for(int i=0; i<=size && !flag; i++){
                for(int[] x : isSubSet[i]){
                    int isDupl = 0;
                    for(int y : x){
                        if(now.contains(y)) isDupl++;
                    }
                    if(isDupl == x.length){
                        flag = true;
                        break;
                    }
                }       
            }
            if(flag) continue;
            
            Set<String> dupl = new HashSet<>();
            flag = false;
            for(int i=0; i<relation.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int x : now){
                    sb.append(relation[i][x]);
                }
                if(dupl.contains(sb.toString())){
                    flag = true;
                    break;
                }
                dupl.add(sb.toString());
            }
            if(!flag){
                cnt++;
                int[] x = new int[now.size()];
                for(int i=0; i<x.length; i++){
                    x[i] = now.get(i);
                }
                isSubSet[now.size()-1].add(x);
                continue;
            }
            
            for(int i=now.get(now.size()-1)+1; i<relation[0].length; i++){
                List<Integer> s = new ArrayList<>(now);
                s.add(i);
                q.addLast(s);
            }
        }
        return cnt;
    }
}