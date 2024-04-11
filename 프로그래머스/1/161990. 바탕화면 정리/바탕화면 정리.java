class Solution {
    int x1 = 0;
    int y1 = 0;
    int x2 = 0;
    int y2 = 0;
    public int[] solution(String[] wallpaper) {
        searchX1(wallpaper);
        searchY1(wallpaper);
        searchX2(wallpaper);
        searchY2(wallpaper);
        
        int[] answer = {x1, y1, x2+1, y2+1};
        return answer;
    }
    
    public void searchY1(String[] wallpaper){
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    x1 = i;
                    return ;
                }
            }
        }
    }
    
    public void searchX1(String[] wallpaper){
        for(int i=0; i<wallpaper[0].length(); i++){
            for(int j=0; j<wallpaper.length; j++){
                if(wallpaper[j].charAt(i) == '#'){
                    y1 = i;
                    return ;
                }
            }
        }
    }
    
    public void searchY2(String[] wallpaper){
        for(int i=wallpaper.length-1; i>=0; i--){
            for(int j=wallpaper[i].length()-1; j>=0 ; j--){
                if(wallpaper[i].charAt(j) == '#'){
                    x2 = i;
                    return ;
                }
            }
        }
    }
    
    public void searchX2(String[] wallpaper){
        for(int i=wallpaper[0].length()-1; i>=0 ;i--){
            for(int j=wallpaper.length-1; j>=0; j--){
                if(wallpaper[j].charAt(i) == '#'){
                    y2 = i;
                    return ;
                }
            }
        }
    }
    
}