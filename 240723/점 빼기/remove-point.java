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

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    static TreeSet<Pair> ts;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ts = new TreeSet<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ts.add(new Pair(x,y));
        }

        for(int i=0; i<m; i++){
            int number = Integer.parseInt(br.readLine());
            Pair ceiling = ts.ceiling(new Pair(number, 0));
            if(ceiling == null){
                System.out.println(-1 + " " + -1);
                continue;
            }
            System.out.println(ceiling);
            ts.remove(ceiling);
        }


    }
}