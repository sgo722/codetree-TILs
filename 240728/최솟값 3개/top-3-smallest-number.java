import java.io.*;
import java.util.*;

public class Main{
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        pq = new PriorityQueue<>((o1,o2) -> o2-o1);
        int n = sc.nextInt();


        long ret = 1;
        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            if(pq.size() != 3){
                ret *= num;
                pq.add(num);
                if(pq.size() == 3){
                    System.out.println(ret);
                } else {
                    System.out.println(-1);
                }
            }else if(pq.size() == 3){
                if(pq.peek() > num){
                    ret /= pq.poll();
                    pq.add(num);
                    ret *= num;
                }
                System.out.println(ret);
            }
        }



    }
}