class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int time = 0;
        boolean bandageFlag = true;
        int bandageTime = 0;
        for(int i=0; i<attacks.length;){
            if(attacks[i][0] == time){
                health -= attacks[i][1];
                if(health <= 0) return -1;
                if(i+1 == attacks.length) break;
                i++;
                bandageFlag = false;
                bandageTime = 1;
                // 공격당하지 않고 붕대 감는 중이라면 붕대 시간 ++
            }else if(bandageFlag){
                bandageTime++;
                // 공격당하지 않고 붕대 감는 중이아니라면 붕대를 감는다.
            }else{
                bandageFlag = true;
            }
            
            // 붕대를 감는 중이고 붕대 시전 시간과 같다면 추가 붕대 회복까지 추가한다.
            if(bandageFlag && bandageTime == bandage[0]){
                bandageTime = 0;
                health = health + bandage[2] + bandage[1] > maxHealth ? maxHealth : health + bandage[2] + bandage[1];
            // 붕대를 감는 중이고 붕대 시전 시간이 0보다 크다면 초당 회복량만큼 회복
            }else if(bandageFlag && bandageTime > 0){
                health = health + bandage[1] > maxHealth ? maxHealth : health + bandage[1];
            }
            time++;
        }
        
        return health;
    }
}