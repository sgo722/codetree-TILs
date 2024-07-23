import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2 - o1);

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        while(pq.size() >= 2){
            Integer a = pq.poll();
            Integer b = pq.poll();
            int gap = Math.abs(a - b);
            if(gap == 0) continue;
            pq.add(gap);
        }

        if(pq.size() == 0) {
            System.out.println(-1);
        }else{
            System.out.println(pq.peek());
        }

    }
}