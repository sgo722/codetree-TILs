import java.util.Scanner;

public class Main{

    static final int MAX_SIZE = 1000004;
    static int n;
    static int[][] map, prefixSum;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n+1][n+1];
        prefixSum = new int[n+1][n+1];
        dp = new int[n+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        prefixSum[0][0] = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + map[i][j];
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            for(int j=i; j<=n; j++){
                ans = Math.max(ans, getMaxArea(i,j));

            }
        }

        System.out.println(ans);
    }

    static int getMaxArea(int sy, int ey){

        for(int x=1; x<=n; x++){
            int value = getSum(sy, x, ey, x);

            dp[x] = Math.max(value, dp[x-1] + value);
        }

        int maxArea = Integer.MIN_VALUE;
        for(int x=1; x<=n; x++){
            maxArea = Math.max(maxArea,dp[x]);
        }

        return maxArea;
    }

    static int getSum(int sy, int sx, int ey ,int ex){
        return prefixSum[ey][ex] - prefixSum[sy-1][ex] - prefixSum[ey][sx-1] + prefixSum[sy-1][sx-1];
    }
}