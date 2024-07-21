import java.io.*;
import java.util.*;

public class Main{
    static TreeSet<Integer> ts;

    static ArrayList<Integer> list;
    static int ans = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        ts = new TreeSet<>((o1, o2) -> o2 - o1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
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
        ans = Math.max(ans, index);

        int number = list.get(index);
        for(int i=number; i>=1; i--){
            if(!ts.contains(i)) {
                ts.add(i);
                dfs(index + 1);
                break;
            }
        }

    }
}