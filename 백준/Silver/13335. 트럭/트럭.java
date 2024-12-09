import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int W;
    static int L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Integer> trucks = new ArrayList();
        for (int i = 0; i < N; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int now = 0;
        ListIterator<Integer> trucksIter = trucks.listIterator();
        boolean isTruckClimb = true;
        Bridge bridge = new Bridge();
        while (trucksIter.hasNext() || !isTruckClimb) {
            if(isTruckClimb) {
                now = trucksIter.next();
            }

            bridge.nextTime();
            if (bridge.climbBridge(now)) {
                isTruckClimb = true;
            } else {
                isTruckClimb = false;
            }

            time++;
        }

        while (bridge.hasTruck()){
            time++;
            bridge.nextTime();
        }

        System.out.println(time);
    }

    public static class Bridge {
        private List<Truck> onTrucks;
        private int totalTruckWeight;

        public Bridge() {
            onTrucks = new ArrayList<>();
            totalTruckWeight = 0;
        }

        public boolean hasTruck(){
            return onTrucks.size() != 0;
        }

        public boolean climbBridge(int truck) {
            if (totalTruckWeight + truck <= L && onTrucks.size() <= W) {
                totalTruckWeight += truck;
                onTrucks.add(new Truck(truck));
                return true;
            }
            return false;
        }

        public void nextTime() {
            Iterator<Truck> truckIter = onTrucks.iterator();

            while (truckIter.hasNext()){
                Truck now = truckIter.next();
                now.forward();

                if(now.isLeaveTruck()){
                    totalTruckWeight = now.leaveTruck(totalTruckWeight);
                    truckIter.remove();
                }
            }
        }
    }

    public static class Truck {
        private int location;
        private int weight;

        public Truck(final int weight) {
            this.location = 1;
            this.weight = weight;
        }

        public boolean isLeaveTruck() {
            return location > W;
        }

        public int leaveTruck(final int totalTruckWeight) {
            return totalTruckWeight - this.weight;
        }

        public void forward() {
            location++;
        }
    }
}