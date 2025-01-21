class Solution {
    public int solution(int[] arr) {
        
        int[] visit = new int[100000000];
        
        int m = 0;
        while(true){
            m++;
            for(int i=0; i<arr.length; i++){
                visit[arr[i] * m]++;
                if(visit[arr[i] * m] == arr.length) return arr[i] * m;
            }
        }
    }
}