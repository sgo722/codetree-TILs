import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2 - o1);

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(num > 0){
                pq.add(num);
            }else{
                Integer poll = pq.poll();
                if(poll == null){
                    System.out.println(0);
                    continue;
                }
                System.out.println(poll);
            }
        }


    }
}