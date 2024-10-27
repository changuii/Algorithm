import java.util.*;
import java.util.stream.*;
class Solution {
    public String solution(String[] seoul) {
        int index = IntStream
            .range(0, seoul.length)
            .filter(i -> seoul[i].equals("Kim"))
            .findFirst()
            .getAsInt();
        return String.format("김서방은 %d에 있다", index);
    }
}