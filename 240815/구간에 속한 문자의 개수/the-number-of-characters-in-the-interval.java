import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main{

    static int[][][] map;
    static int[][][] sum;
    static int n,m,k, r1,r2,c1,c2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        map = new int[3][n+1][m+1];
        sum = new int[3][n+1][m+1];

        for(int i=1; i<=n; i++){
            String s = br.readLine();
            for(int j=1; j<=m; j++){
                map[s.charAt(j-1)-'a'][i][j] = 1;
            }
        }

        for(int idx=0; idx<3; idx++){
            for(int i=1; i<=n; i++){
                for(int j=1; j<=m; j++) {
                    sum[idx][i][j] = sum[idx][i-1][j] + sum[idx][i][j-1] - sum[idx][i-1][j-1] + map[idx][i][j];
                }
            }
        }

        for(int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            int aCount = 0;
            int bCount = 0;
            int cCount = 0;
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            aCount = sum[0][r2][c2] + sum[0][r1-1][c1-1] - sum[0][r1-1][c2] - sum[0][r2][c1-1];
            bCount = sum[1][r2][c2] + sum[1][r1-1][c1-1] - sum[1][r1-1][c2] - sum[1][r2][c1-1];
            cCount = sum[2][r2][c2] + sum[2][r1-1][c1-1] - sum[2][r1-1][c2] - sum[2][r2][c1-1];
            System.out.println(aCount + " " + bCount + " " + cCount);
        }



    }
}