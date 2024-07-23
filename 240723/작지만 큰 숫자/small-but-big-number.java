import java.io.*;
import java.util.*;

public class Main {
    static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for(int i=0; i<n; i++){
            set.add(sc.nextInt());
        }

        for(int i=0; i<m; i++){
            Integer floor = set.floor(sc.nextInt());
            if(floor == null){
                System.out.println(-1);
            }else{
                set.remove(floor);
                System.out.println(floor);
            }
        }

    }
}