import java.util.*;
class Solution {
    ArrayList<Integer>[] A;
    boolean[] V;
    int count = 0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        A = new ArrayList[n];
        V = new boolean[n];
        for(int i=0; i<n; i++){
            A[i] = new ArrayList<>();
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(computers[i][j] == 1){
                    A[i].add(j);
                }
            }
        }
        for(int i=0; i<n; i++){
            count = 0;
            DFS(i);
            if(count > 0) answer++;
        }
        
        
        return answer;
    }
    
    public void DFS(int a){
        if(V[a]) return;
        
        count++;
        V[a] = true;
        for(int x : A[a]){
            if(!V[x]){
                DFS(x);
            }
        }
    }
}