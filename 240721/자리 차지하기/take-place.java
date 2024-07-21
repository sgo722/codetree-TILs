import java.io.*;
import java.util.*;

public class Main{
    static TreeSet<Integer> ts;

    static ArrayList<Integer> list;
    static int ans = 0;
    static int n;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        ts = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int number = Integer.parseInt(st.nextToken());
            list.add(number);
        }

        for(int i=1; i<=m; i++){
            ts.add(i);
        }

        int count = 0;
        for(int i=0; i<n; i++){
            Integer number = list.get(i);
            Integer floor = ts.floor(number);
            if(floor == null){
                System.out.println(count);
                return;
            }
            ts.remove(floor);
            count++;
        }

        System.out.println(count);
    }
}