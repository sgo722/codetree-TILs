import java.io.*;
import java.util.*;

public class Main {
    static class Swap{
        int from;
        int to;

        public Swap(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Swap swap = (Swap) o;
            return from == swap.from && to == swap.to;
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }


    static int[] arr, ans, a,b;
    static HashSet<Integer>[] set;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        set = new HashSet[n+1];

        for(int i=0; i<=n; i++){
            set[i] = new HashSet<>();
        }
        arr = new int[n+1];
        ans = new int[n+1];
        a = new int[m+1];
        b = new int[m+1];
        for(int i=1; i<=n; i++){
            arr[i] = i;
            set[i].add(i);
            ans[i] = 1;
        }
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<3; i++) {
            for(int j=1; j<=m; j++) {
                int temp = arr[a[j]];
                arr[a[j]] = arr[b[j]];
                arr[b[j]] = temp;

                if (!set[arr[a[j]]].contains(a[j])) {
                    set[arr[a[j]]].add(a[j]);
                    ans[arr[a[j]]]++;
                }


                if (!set[arr[b[j]]].contains(b[j])) {
                    set[arr[b[j]]].add(b[j]);
                    ans[arr[b[j]]]++;
                }
            }
        }

        for(int i=1; i<=n; i++){
            System.out.println(ans[i]);
        }
    }
}