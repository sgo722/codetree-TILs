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
        for(int i=0; i<n; i++){
            ts.add(Integer.parseInt(st.nextToken()));
        }


        for(int i=0; i<m; i++){
            int num = Integer.parseInt(br.readLine());
            Integer ceiling = ts.ceiling(num);
            if(ceiling == null){
                System.out.println(-1);
            }else{
                System.out.println(ceiling);
            }
        }

    }
}