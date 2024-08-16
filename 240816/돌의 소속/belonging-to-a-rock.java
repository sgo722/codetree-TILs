import java.io.*;
import java.util.*;

public class Main{
    static int n, q;

    static ArrayList<Integer> list;

    static int[][] prefixSum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        prefixSum = new int[4][n+1];

        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        for(int i=1; i<=n; i++){
            for(int matchNumber=1; matchNumber<=3; matchNumber++){
                if(matchNumber == list.get(i-1)){
                    prefixSum[matchNumber][i] = prefixSum[matchNumber][i-1] + 1;
                }else {
                    prefixSum[matchNumber][i] = prefixSum[matchNumber][i - 1];
                }
            }
        }

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int firstGroup = prefixSum[1][end] - prefixSum[1][start-1];
            int secondGroup = prefixSum[2][end] - prefixSum[2][start-1];
            int thirdGroup = prefixSum[3][end] - prefixSum[3][start-1];

            System.out.println(firstGroup + " " + secondGroup + " " + thirdGroup);
        }

    }
}