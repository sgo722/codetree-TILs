import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[] map, prefixSum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n+1];
        prefixSum = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1] + map[i];
        }


        int count = 0;
        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                int curSum = prefixSum[i] - prefixSum[j];
                if(curSum == k){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}