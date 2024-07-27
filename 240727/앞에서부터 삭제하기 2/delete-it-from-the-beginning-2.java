import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list;
    static ArrayList<Integer> sum;
    static PriorityQueue<Integer> pq;
    static double maxAvg = 0;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        pq = new PriorityQueue();
        list = new ArrayList<>();
        sum = new ArrayList<>();
        int n = sc.nextInt();
        int sumVal = 0;

        for(int i=0; i<n; i++){
            int number = sc.nextInt();
            list.add(number);
        }

        pq.add(list.get(n-1));
        sumVal += list.get(n-1);

        for(int i=n-2; i>=1; i--){
            pq.add(list.get(i));
            sumVal += list.get(i);

            double avg = (double)(sumVal - pq.peek()) / (n-1-i);

            if(maxAvg < avg){
                maxAvg = avg;
            }
        }
        System.out.printf("%.2f", maxAvg);
    }
}