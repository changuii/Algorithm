class Solution {
    int count = 0;
    public int solution(int[] numbers, int target) {
        DFS(0, 0, target, numbers);
        return count;
    }
    
    public void DFS(int value, int depth, int target, int[] numbers){
        if(depth == numbers.length){
            if(value == target) count++;
        }else{
            DFS(value+numbers[depth], depth+1, target, numbers);
            DFS(value-numbers[depth], depth+1, target, numbers);
        }
            
    }
}