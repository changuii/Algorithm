import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[][] reportList = new int[id_list.length][id_list.length];
        int[] A = new int[id_list.length];
        
        StringTokenizer st;
        for(String value : report){
            st = new StringTokenizer(value, " ");
            String sender = st.nextToken();
            String receiver = st.nextToken();
            int x = 0;
            int y = 0;
            for(int i=0; i<reportList.length; i++){
                if(id_list[i].equals(sender)) x = i;
            }
            for(int i=0; i<reportList.length; i++){
                if(id_list[i].equals(receiver)) y = i;
            }
            if(reportList[x][y] == 0){
                A[y]++;
                reportList[x][y]++;
            }
        }
        int[] answer = new int[id_list.length];
        for(int i=0; i<A.length; i++){
            if(A[i] >= k){
                for(int j=0; j<A.length; j++){
                    if(reportList[j][i] > 0) answer[j]++;  
                }
            }
        }
        return answer;
    }
}