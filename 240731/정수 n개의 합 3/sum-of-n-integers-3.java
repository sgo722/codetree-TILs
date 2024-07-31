import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] map, sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        sum = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i][j];
            }
        }


//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=n; j++){
//                System.out.print(sum[i][j] + " ");
//            }
//            System.out.println();
//        }

        int ans = 0;
        for(int i=k; i<=n; i++){
            for(int j=k; j<=n; j++){
                int box = sum[i][j] - sum[i-k][j] - sum[i][j-k] + sum[i-k][j-k];
                ans = Math.max(box,ans);
            }
        }

        System.out.println(ans);
    }
}