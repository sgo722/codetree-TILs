import java.io.*;
import java.util.*;

public class Main{
    static TreeSet<Integer> ts;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ts = new TreeSet<>();
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if(op.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                ts.add(num);
            }else if(op.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                ts.remove(num);
            }else if(op.equals("find")){
                int num = Integer.parseInt(st.nextToken());
                if(ts.contains(num)){
                    System.out.println("true");
                }else{
                    System.out.println("false");
                }
            }else if(op.equals("largest")){
                if(ts.isEmpty()){
                    System.out.println("None");
                }else{
                    System.out.println(ts.last());
                }
            }else if(op.equals("smallest")){
                if(ts.isEmpty()){
                    System.out.println("None");
                }else{
                    System.out.println(ts.first());
                }
            }else if(op.equals("lower_bound")){
                int num = Integer.parseInt(st.nextToken());
                Integer ceiling = ts.ceiling(num);
                if(ceiling == null){
                    System.out.println("None");
                    continue;
                }
                System.out.println(ceiling);
            }else if(op.equals("upper_bound")){
                int num = Integer.parseInt(st.nextToken());
                Integer higher = ts.higher(num);
                if(higher == null){
                    System.out.println("None");
                    continue;
                }
                System.out.println(higher);
            }
        }

    }
}