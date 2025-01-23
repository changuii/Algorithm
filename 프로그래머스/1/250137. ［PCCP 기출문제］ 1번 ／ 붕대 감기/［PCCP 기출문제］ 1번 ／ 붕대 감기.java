class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int time = 0;
        int currentHealth = health;
        for(int[] attack : attacks){
            int currentTime = attack[0];
            int damage = attack[1];
            
            int beforeTime = currentTime - time - 1;
            int beforeHeal = calculateHeal(bandage, beforeTime);
            currentHealth  = currentHealth + beforeHeal > health ? health : currentHealth + beforeHeal;
            currentHealth -= damage;
            
            
            time = currentTime;
            if(currentHealth <= 0) return -1;
        }
        
        return currentHealth;
    }
    
    public int calculateHeal(int[] bandage, int time){
        return bandage[1] * time + (time / bandage[0] * bandage[2]);
    }
}