import java.util.stream.*;
class Solution {
    public String solution(String phone_number) {
        return IntStream.range(0, phone_number.length())
            .mapToObj(i -> i >= phone_number.length()-4 ? Character.toString(phone_number.charAt(i)) : "*")
            .collect(Collectors.joining());
    }
}