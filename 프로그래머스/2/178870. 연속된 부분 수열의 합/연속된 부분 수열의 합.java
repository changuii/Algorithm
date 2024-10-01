class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int[] answer = new int[2];
        int l=Integer.MAX_VALUE;
        
        int i =0;
        int j =0;
        int length = 1;
        int sum = sequence[i];
        while(j+1 < sequence.length){
            if(sum == k && length < l){
                answer[0] = i;
                answer[1] = j;
                l = length;
                length--;
                sum -= sequence[i++];
            }
            else if(j+1 < sequence.length && sum < k){
                sum += sequence[++j];
                length++;
            }
            else{
                sum -= sequence[i++];
                length--;
            }
        }
        
        while(i <= j){
            if(sum == k && length < l){
                answer[0] = i;
                answer[1] = j;
                l = length;
                length--;
                sum -= sequence[i++];
            }
            else{
                sum -= sequence[i++];
                length--;
            }
        }
        
        
        return answer;
    }
}