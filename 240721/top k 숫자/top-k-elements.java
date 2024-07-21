import java.io.*;
import java.util.*;

public class Main{
    static TreeSet<Integer> ts;
    static int dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ts = new TreeSet<>((o1, o2) -> o2 - o1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(st.nextToken());
            ts.add(number);
        }

        for(int i=0; i<m; i++){
            Integer first = ts.first();
            ts.remove(first);
            sb.append(first + " ");
        }

        System.out.println(sb);


    }
}