import java.io.*;
import java.util.*;

public class Main{
    static TreeSet<Integer> ts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ts = new TreeSet<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int firstNumber = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(-1);
            return;
        }
        ts.add(firstNumber);
        int diff = Integer.MAX_VALUE;
        for(int i=1; i<n; i++){
            int number = Integer.parseInt(br.readLine());
            Integer ceiling = ts.ceiling(number);
            Integer floor = ts.floor(number);
            if(ceiling != null){
                int CurDiff = ceiling - number;
                if(CurDiff >= m) {
                    diff = Math.min(diff, CurDiff);
                }
            }
            if(floor != null){
                int CurDiff = number - floor;
                if(CurDiff >= m) {
                    diff = Math.min(diff, CurDiff);
                }
            }
            ts.add(number);
        }
        if (diff == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(diff);
        }
    }
}