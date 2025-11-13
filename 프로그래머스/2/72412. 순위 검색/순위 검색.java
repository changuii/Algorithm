import java.util.*;
class Solution {
    static String[][] info;
    public int[] solution(String[] info, String[] query) {
        
        this.info = new String[info.length][5];
        for(int i=0; i<info.length; i++) {
            this.info[i] = info[i].split(" ");
        }
        
        
        int[] answer = new int[query.length];
        for(int i=0; i<query.length; i++) {
            String[] q = query[i].split(" ");
            
            String lang = q[0];
            String type = q[2];
            String year = q[4];
            String food = q[6];
            String score = q[7];   
            answer[i] = query(lang, type, year, food, score);
        }
        return answer;
    }
    
    public int query(String lang, String type, String year, String food, String score) {
        int c =0;
        for(int i=0; i<info.length; i++) {
            if(Integer.parseInt(info[i][4]) < Integer.parseInt(score)) continue;
            if(!"-".equals(lang) && !info[i][0].equals(lang)) continue;
            if(!"-".equals(type) && !info[i][1].equals(type)) continue;
            if(!"-".equals(year) && !info[i][2].equals(year)) continue;
            if(!"-".equals(food) && !info[i][3].equals(food)) continue;
            c++;
        }
        
        return c;
    }
}