import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, absolutes.length)
            .map(index -> signs[index] ? absolutes[index] : absolutes[index] * -1)
            .sum();
    }
}