import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> list;
    static ArrayList<Integer> sum;
    static PriorityQueue<Integer> pq;
    static double ans;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        pq = new PriorityQueue();
        list = new ArrayList<>();
        sum = new ArrayList<>();
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int number = sc.nextInt();
            list.add(number);
            pq.add(number);
        }

        sum.add(list.get(0));
        for(int i=1; i<n; i++){
            sum.add(sum.get(i-1) + list.get(i));
        }
        ans = 0;

        for(int i=0; i<n-2; i++){
            int ret = sum.get(n - 1) - sum.get(i);
            pq.remove(list.get(i));
            Integer peek = pq.peek();
            ret -= peek;
            double avg = (double) ret / (n-1-i-1);
            ans = Math.max(ans, avg);
        }

        System.out.printf("%.02f",ans);
    }
}