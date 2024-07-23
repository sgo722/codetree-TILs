import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxSum = 0;
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(st.nextToken());
            maxSum += number;
            pq.add(number);
        }

        maxSum -= pq.poll(); // n-1개가 된다.
        BigDecimal ans = BigDecimal.valueOf(0);
        for(int i=1; i<n-1; i++){
            BigDecimal curAvg = BigDecimal.valueOf(maxSum).divide(BigDecimal.valueOf(n-i),2, RoundingMode.CEILING);
            int number = curAvg.compareTo(ans);
            if(number == 1){
                ans = curAvg;
            }
            maxSum -= pq.poll();
        }
        System.out.println(ans);

    }
}