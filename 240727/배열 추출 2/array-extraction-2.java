import java.io.*;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point>{
        int num;

        public Point(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Point o) {
            if(Math.abs(this.num) != Math.abs(o.num)){
                return Math.abs(this.num) - Math.abs(o.num);
            }
            return this.num - o.num;

        }
    }


    static PriorityQueue<Point> pq;
    public static void main(String[] args) throws Exception{
        pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(num != 0){
                Point point = new Point(num);
                pq.add(point);
            }else{
                if(pq.size() == 0){
                    System.out.println(0);
                }else{
                    Point poll = pq.poll();
                    int pollNumber = poll.num;
                    System.out.println(pollNumber);
                }
            }
        }
    }
}