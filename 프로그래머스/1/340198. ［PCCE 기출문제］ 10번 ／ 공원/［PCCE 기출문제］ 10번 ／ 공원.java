import java.util.*;
class Solution {
    public int solution(int[] mats, String[][] park) {
        mats = Arrays.stream(mats)
            .map((i) -> i-1)
            .sorted()
            .toArray();
        
        int answer = -1;
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length; j++){
                if(!park[i][j].equals("-1")) continue;
                
                for(int m=mats.length-1; m>answer; m--){
                    if(check(i, j, mats[m], park)){
                        answer = m;
                        break;
                    }
                }
            }
        }
        
        return answer == -1 ? answer : mats[answer] + 1;
    }
    
    public boolean check(int x, int y, int mat, String[][] park){
        if(mat + x >= park.length || mat + y >= park[0].length) return false;
        
        for(int i=x; i<=x + mat; i++){
            for(int j=y; j<=y + mat; j++){
                if(!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}