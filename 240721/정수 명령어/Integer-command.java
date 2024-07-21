import java.io.*;
import java.util.*;

public class Main{
    static TreeSet<Integer> ts;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        ts = new TreeSet<>();
        StringTokenizer st;

        for(int i=0; i<t; i++){
            ts.clear();
            int n = Integer.parseInt(br.readLine());
            for(int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int number = Integer.parseInt(st.nextToken());
                if(op.equals("I")){
                    ts.add(number);
                }else if(!ts.isEmpty() && op.equals("D")){
                    if(number == 1){
                        Integer last = ts.last();
                        ts.remove(last);
                    }else if(number == -1){
                        Integer first = ts.first();
                        ts.remove(first);
                    }
                }
            }

            if(!ts.isEmpty()) {
                System.out.println(ts.last() + " " + ts.first());
            }else{
                System.out.println("EMPTY");
            }
        }


    }
}