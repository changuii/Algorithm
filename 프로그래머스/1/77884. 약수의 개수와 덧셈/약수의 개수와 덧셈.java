import java.util.stream.*;
class Solution {
    public int solution(int left, int right) {
        return IntStream.range(left, right+1)
            .map(i -> count(i) % 2 == 0 ? i : i * -1)
            .sum();
    }
    
    public int count(int val){
        return IntStream.range(1, val + 1)
            .map(i -> val % i == 0 ? 1 : 0)
            .sum();
    }
}