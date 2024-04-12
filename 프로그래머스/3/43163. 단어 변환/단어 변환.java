import java.math.*;
class Solution {
    int min = 1000;
    public int solution(String begin, String target, String[] words) {
        int count = 0;
        for(int i=0; i<words.length; i++){
            if(target.equals(words[i])){
                count++;
                break;
            }
            
        }
        if(count == 0) return 0;
        
        DFS(0, begin, target, words);
        return min == 1000 ? 0 : min;
    }
    
    public void DFS(int depth, String begin, String target, String[] words){
        if(min < depth) return;
        
        if(begin.equals(target)){
            min = Math.min(depth, min);
        }else{
            for(int i=0; i<words.length; i++){
                if(isSame(begin, words[i])){
                    DFS(depth+1, words[i], target, words);
                }
            }
        }
    }
    
    public boolean isSame(String value1, String value2){
        int count = 0;
        for(int i=0; i<value1.length(); i++){
            if(value1.charAt(i) == value2.charAt(i)) count++;
        }
        if(value1.length() - count == 1 ){
            return true;
        }
        return false;
    }
}