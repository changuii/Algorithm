class Solution {
    public long[] solution(long[] numbers) {
        //1: 01 -> 10 2 -> +1
        //2: 10 -> 11 3 -> +1 
        //3: 11 -> 101 5 -> +2
        //4: 100 -> 101 5 -> +1
        //5: 101 -> 110 6 -> +1
        //6: 110 -> 111 7 -> +1
        //7: 111 -> 1011 11 -> +4
        //8: 1000 -> 1001 9 -> +1
        //9: 1001 -> 1010 10 -> +1
        //10: 1010 -> 1011 11 -> +1
        //11: 1011 -> 1101 13 -> +2
        //12: 1100 -> 1101 13 -> +1
        //13: 1101 -> 1110 14 -> +1
        //14: 1110 -> 1111 15 -> +1
        //15: 1111 -> 10111 23 -> +8
        
        for(int i=0; i<numbers.length; i++) {
            int count = 0;
            long val = numbers[i];
            
            while(val % 2 == 1) {
                count++;
                val /= 2;
            }
            if(count == 0) count = 1;
            numbers[i] = numbers[i] + (long) Math.pow(2, count - 1);
        }
         
        
        return numbers;
    }
}