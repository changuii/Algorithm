import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int i = 0;
        int j = people.length-1;
        int c = 0;
        while(i <= j){
            if(people[i] + people[j] > limit){
                j--;
                c++;
            } else {
                i++;
                j--;
                c++;
            }
        }
        
        return c;
    }
}