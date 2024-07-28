import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_NUM = 100004;
    static int[] arr, sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[MAX_NUM];
        sum = new int[MAX_NUM];
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum[0] = 0;
        for(int i=1; i<=n; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        int ans = 0;
        for(int i=k; i<=n; i++){
            ans = Math.max(ans, sum[i] - sum[i - k]);
        }
        System.out.println(ans);

    }
}