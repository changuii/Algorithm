import java.util.*;

class Solution {
    int x;
    int y;
    // 북 동 남 서
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public int[] solution(String[] park, String[] routes) {
        searchDog(park);
        StringTokenizer st;
        for(String now : routes){
            st = new StringTokenizer(now, " ");
            move(st.nextToken(), Integer.parseInt(st.nextToken()), park);
        }
        int[] answer = {x, y};
        return answer;
    }
    
    public void searchDog(String[] park){
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    this.x = i;
                    this.y = j;
                    return;
                }
            }
        }
    }
    
    public int direction(String dir){
        if(dir.equals("N")) return 0;
        else if(dir.equals("E")) return 1;
        else if(dir.equals("S")) return 2;
        else return 3;
    }
    
    public void move(String dir, int distance, String[] park){
        int beforeX = x;
        int beforeY = y;
        
        int direction = direction(dir);
        for(int i=0; i<distance; i++){
            int valueX = x + dx[direction];
            int valueY = y + dy[direction];
            if(valueX < 0 || valueX >= park.length || valueY < 0 || valueY >= park[0].length()
                    || park[valueX].charAt(valueY) == 'X'){
                x = beforeX;
                y = beforeY;
                return ;
            }
            x = valueX;
            y = valueY;
        }
        
    }
    
    
}