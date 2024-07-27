import java.io.*;
import java.util.*;

public class Main{
    static PriorityQueue<Integer> max_pq, min_pq;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int median;
        for(int i=0; i<t; i++){
            min_pq = new PriorityQueue<>((o1,o2) -> o2 - o1);
            max_pq = new PriorityQueue<>();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());


            int firstNumber = Integer.parseInt(st.nextToken());
            median = firstNumber;
            min_pq.add(firstNumber);
            sb.append(firstNumber + " ");
            for(int j=0; j<n-1; j++){
                int num = Integer.parseInt(st.nextToken());
                if(median < num){
                    max_pq.add(num);
                }
                if(median >= num){
                    min_pq.add(num);
                }
                if(j%2 == 1){
                    if(max_pq.size() < min_pq.size()){
                        while(max_pq.size()+1 < min_pq.size()){
                            Integer poll = min_pq.poll();
                            max_pq.add(poll);
                        }
                        Integer changeMid = min_pq.peek();
                        median = changeMid;
                        sb.append(changeMid + " ");
                    }

                    else if(max_pq.size() > min_pq.size()){
                        while(max_pq.size() > min_pq.size()+1){
                            Integer poll = max_pq.poll();
                            min_pq.add(poll);
                        }
                        Integer changeMid = max_pq.peek();
                        median = changeMid;
                        sb.append(median + " ");
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}