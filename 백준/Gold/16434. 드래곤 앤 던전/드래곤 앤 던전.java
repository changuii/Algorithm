import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Room[] rooms = new Room[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            rooms[i] = new Room(a == 1, b, c);
        }

        Hero hero = new Hero(0, 0, M);

        long l = 1;
        long h = 2L << 59;
        long mid = 0;

        while (l <= h) {
            mid = l + ( h - l) / 2 ;

            hero.currentHealth = mid;
            hero.maxHealth = mid;
            hero.attack=M;
            if(check(rooms, hero)){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        System.out.println(h + 1);
        
 
    }

    public static boolean check(Room[] rooms, Hero hero){
        for(Room r : rooms){
            if(!r.intoRoom(hero)) return false;
        }
        return true;
        
    }

    public static class Room{
        boolean isMonster;
        long attack;
        long health;

        public Room(boolean m, int a, int h){
            this.isMonster=m;
            this.attack=a;
            this.health=h;
        }

        public boolean intoRoom(Hero hero){
            if(isMonster){
                long temp = health;

                long heroAttack = this.health / hero.attack + (this.health % hero.attack == 0 ? 0 : 1); 
                long monsterAttack = hero.currentHealth / this.attack + (hero.currentHealth % this.attack == 0 ? 0 : 1);

                // 용사 6 -> 5
                // 

                
                hero.currentHealth -= (heroAttack - 1) * this.attack;
                return monsterAttack >= heroAttack;
            }
            else{
                hero.attack += attack;
                if(hero.currentHealth + this.health > hero.maxHealth) hero.currentHealth = hero.maxHealth;
                else hero.currentHealth += this.health;
                return true;
            }
        }
        
    }

    public static class Hero{
        long maxHealth;
        long currentHealth;
        long attack;

        public Hero(int m, int c, int a){
            this.maxHealth=m;
            this.currentHealth=c;
            this.attack=a;
        }
    }
}