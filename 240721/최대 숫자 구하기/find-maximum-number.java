import java.io.*;
import java.util.*;

public class Main{
    static TreeSet<Integer> ts;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ts = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=m; i++){
            ts.add(i);
        }

        for(int i=0; i<n; i++){
            int number = Integer.parseInt(st.nextToken());
            ts.remove(number);
            Integer maxNumber = ts.last();
            System.out.println(maxNumber);
        }
    }
}