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

        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int index){
        if(index == n){
            return;
        }

        int number = list.get(index);
        for(int i=number; i>=1; i--){
            if(!ts.contains(i)) {
                ts.add(i);
                dfs(index + 1);
                ans = Math.max(ans, index+1);
                break;
            }
        }

    }
}