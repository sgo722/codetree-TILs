import java.io.*;
import java.util.*;

public class Main{
    static class Pair implements Comparable<Pair>{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
    static TreeSet<Pair> ts;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ts = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Pair pair = new Pair(x, y);
            ts.add(pair);
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Pair pair = new Pair(x, y);
            Pair findPair = ts.ceiling(pair);

            if(findPair == null){
                System.out.println("-1 -1");
            }else{
                System.out.println(findPair.x + " " + findPair.y);
            }
        }
    }
}