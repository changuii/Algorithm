class Solution {
    boolean solution(String s) {
        int start = 0;
        int end = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') start++;
            else end++;
            
            if(start < end) return false;
        }
        
        return start == end;
    }
}