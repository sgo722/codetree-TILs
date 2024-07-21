import java.io.*;
import java.util.*;

public class Main{
    static TreeSet<Integer> ts;
    static int dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ts = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ts.add(0);
        dist = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(st.nextToken());
            ts.add(number);
            Integer higher = ts.higher(number);
            Integer lower = ts.lower(number);
            if(higher != null) {
                dist = Math.min(dist, higher - number);
            }
            dist = Math.min(dist, number - lower);
            System.out.println(dist);
        }


    }
}