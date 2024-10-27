import java.util.stream.*;
class Solution {
    public String solution(int n) {
        return IntStream.range(1, n+1)
            .mapToObj(i -> i % 2 == 1 ? "수" : "박")
            .collect(Collectors.joining());
    }
}