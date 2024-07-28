import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point>{
        int idx;
        int arriveTime;
        int stayTime;

        public Point(int idx, int arriveTime, int stayTime) {
            this.idx = idx;
            this.arriveTime = arriveTime;
            this.stayTime = stayTime;
        }

        @Override
        public int compareTo(Point o) {
            if(this.arriveTime != o.arriveTime){
                return this.arriveTime - o.arriveTime;
            }
            return this.idx - o.idx;
        }
    }



    static class Wait implements Comparable<Wait>{
        int idx;
        int arriveTime;
        int stayTime;

        @Override
        public String toString() {
            return "Wait{" +
                    "idx=" + idx +
                    ", arriveTime=" + arriveTime +
                    ", stayTime=" + stayTime +
                    '}' + "\n";
        }

        public Wait(int idx, int arriveTime, int stayTime) {
            this.idx = idx;
            this.arriveTime = arriveTime;
            this.stayTime = stayTime;
        }

        @Override
        public int compareTo(Wait o) {
            return this.idx - o.idx;
        }
    }


    static PriorityQueue<Point> wantGoGarden;

    static PriorityQueue<Wait> wait;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        wantGoGarden = new PriorityQueue<>();
        wait = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int arriveTime = Integer.parseInt(st.nextToken());
            int stayTime = Integer.parseInt(st.nextToken());
            wantGoGarden.add(new Point(i, arriveTime, stayTime));
        }
        Point start = wantGoGarden.poll();
        int ans = 0;
        int curTime = start.arriveTime + start.stayTime;;
        while(!wantGoGarden.isEmpty() || !wait.isEmpty()){ // 정원을 방문하고 싶은 사람이 빌때까지
            while(!wantGoGarden.isEmpty() && curTime >= wantGoGarden.peek().arriveTime){
                Point point = wantGoGarden.poll();
                wait.add(new Wait(point.idx, point.arriveTime, point.stayTime));
            }
            if(wait.size() > 0) {
                Wait nextPerson = wait.poll();
                int arriveTime = nextPerson.arriveTime;
                int stayTime = nextPerson.stayTime;
                if (curTime < arriveTime) { // 기다리지 않아도 되는 사람
                    curTime = arriveTime + stayTime;
                } else { // 기다려야하는 사람
                    ans = Math.max(ans, curTime - arriveTime);
                    curTime = curTime + stayTime;
                }
            }else{
                Point nextPerson = wantGoGarden.poll();
                int arriveTime = nextPerson.arriveTime;
                int stayTime = nextPerson.stayTime;
                if (curTime < arriveTime) { // 기다리지 않아도 되는 사람
                    curTime = arriveTime + stayTime;
                } else { // 기다려야하는 사람
                    ans = Math.max(ans, curTime - arriveTime);
                    curTime = curTime + stayTime;
                }
            }
        }

        System.out.println(ans);
    }
}