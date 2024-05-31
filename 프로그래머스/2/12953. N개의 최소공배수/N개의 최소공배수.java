import java.util.Arrays;
class Solution {
    public int solution(int[] arr) {
        
        
        int s = arr[0];
        for(int i=1; i<arr.length; i++){
            int x = 1;
            while(true){
                if(s > arr[i]){
                    if((x * s) % arr[i] == 0){
                        s = x*s;
                        break;
                    }else x++;
                }else{
                    if((x * arr[i]) % s == 0){
                        s = x* arr[i];
                        break;
                    }else x++;
                }
            }
        }
        return s;
    }
}