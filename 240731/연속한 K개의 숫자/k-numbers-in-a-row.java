import java.util.Scanner;

public class Main{

    static final int INT_MAX = Integer.MAX_VALUE;
    static final int MAX_N = 100000;

    static int n,k,b;
    static int[] arr = new int[MAX_N + 1];
    static int[] prefixSum = new int[MAX_N + 1];
    static int ans = INT_MAX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        b = sc.nextInt();

        while(b-- > 0){
            int x = sc.nextInt();
            arr[x] = 1;
        }

        prefixSum[0] = 0;
        for(int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for(int i=1; i<= n-k+1; i++){
            ans = Math.min(ans, getSum(i, i+k-1));
        }

        System.out.println(ans);
    }

    static int getSum(int s ,int e){
        return prefixSum[e] - prefixSum[s-1];
    }
}