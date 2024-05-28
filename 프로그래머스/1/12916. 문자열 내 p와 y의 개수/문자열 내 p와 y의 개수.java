class Solution {
    boolean solution(String s) {
        char[] A = s.toCharArray();
        
        int c=0;
        for(char x : A){
            if(x == 'p' || x == 'P') c++;
            else if(x == 'y' || x == 'Y') c--;
        }
        return c == 0;
    }
}