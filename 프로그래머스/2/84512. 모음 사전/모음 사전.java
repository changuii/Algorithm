class Solution {
    static String target;
    static char[] words = {'A', 'E', 'I', 'O', 'U'};
    static int cnt = 0;
    static boolean find = false;
    public int solution(String word) {
        target = word;
        DFS("");
        return cnt;
    }
    
    public void DFS(String now){
        if(now.equals(target)){
            find = true;
        }
        if(now.length() == 5) return;
        
        
        for(int i=0; i<words.length && !find; i++){
            DFS(now + words[i]);
            cnt++;
        }
        
    }
}