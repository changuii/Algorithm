import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(String t, String p) {
        return (int) IntStream.range(0, t.length() - p.length() + 1)
            .map(i -> Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p) ? 1 : 0)
            .filter(i -> i == 1)
            .count();
    }
}