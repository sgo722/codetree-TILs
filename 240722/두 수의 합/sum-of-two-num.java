import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static long[] arr;
    static HashMap<Long, Integer> map;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n];
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            long num = Long.parseLong(st.nextToken());
            arr[i] = num;
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            long diff = m - arr[i];
            if(map.containsKey(diff)){
                ans += map.get(diff);
            }

            if(!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else{
                map.put(arr[i], map.get(arr[i]) + 1);
            }

        }

        System.out.println(ans);
    }
}