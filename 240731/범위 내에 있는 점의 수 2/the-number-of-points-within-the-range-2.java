import java.util.Scanner;

public class Main{

    static final int MAX_SIZE = 1000004;
    static int n,q;
    static int[] num, prefixSum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        q = sc.nextInt();
        num = new int[MAX_SIZE];
        prefixSum = new int[MAX_SIZE];

        for(int i=0; i<n; i++){
            int idx = sc.nextInt();
            num[idx] = 1;
        }

        prefixSum[0] = 0;
        for(int i=1; i<=1000000; i++){
            prefixSum[i] = prefixSum[i-1] + num[i];
        }

        for(int i=0; i<q; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            if(s != 0) {
                System.out.println(prefixSum[e] - prefixSum[s - 1]);
            }
            if(s == 0){
                System.out.println(prefixSum[e]);
            }
        }


    }
}