class Solution {
    boolean solution(String s) {
        char[] A = s.toCharArray();
        
        int cp=0;
        int cy=0;
        for(char x : A){
            if(x == 'p' || x == 'P') cp++;
            else if(x == 'y' || x == 'Y') cy++;
        }
        return cp == cy;
    }
}