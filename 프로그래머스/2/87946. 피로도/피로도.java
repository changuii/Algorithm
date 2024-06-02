class Solution {
    boolean[] visit;
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        visit = new boolean[dungeons.length];
        DFS(k, dungeons, 0);
        
        return max;
    }
    
    public void DFS(int k, int[][] dungeons, int value){
        max = Math.max(max, value);
        
        for(int i=0; i<dungeons.length; i++ ){
            if(!visit[i] && dungeons[i][0] <= k){
                visit[i] = true;
                DFS(k-dungeons[i][1], dungeons, value+1 );
                visit[i] = false;
            }
        }
        
    }
}