import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2 - o1);
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<m; i++){
            Integer poll = pq.poll();
            pq.add(poll-1);
        }

        System.out.println(pq.peek());

    }
}