import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int n,k;
    static int[][] map, sum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
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
                sum[i][j] = sum[i][j-1] + map[i][j];
            }
        }

        int ans = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                int ret = 0;
                for(int len=k; len>=0; len--) {
                    int row = i+len-k;
                    // i, i-1, i-2, i-3
                    if(row < 0) break;
                    int startColumn = Math.max(j - len, 1);
                    int endColumn = Math.min(j + len, n);
                    ret = ret +  sum[row][endColumn] - sum[row][startColumn-1];
                }

                for(int len=k-1; len>=0; len--){
                    int row = i+k-len;
                    if(row > n) break;
                    int startColumn = Math.max(j - len, 1);
                    int endColumn = Math.min(j + len, n);
                    ret = ret + sum[row][endColumn] - sum[row][startColumn-1];
                }
                ans = Math.max(ans, ret);
            }
        }

        System.out.println(ans);
    }
}