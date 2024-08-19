import java.io.*;
import java.util.*;

public class Main{

    static int n,q;
    static TreeSet<Integer> treeSet;
    static TreeMap<Integer, Integer> treeMap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        treeSet = new TreeSet<>();
        treeMap = new TreeMap<>();

        n = sc.nextInt();
        q = sc.nextInt();

        for(int i=0; i<n; i++){
            int number = sc.nextInt();
            treeSet.add(number);
        }

        int count = 1;
        for(int number : treeSet){
            treeMap.put(number, count);
            count++;
        }

        for(int i=0; i<q; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            Integer ceiling = treeSet.ceiling(s);
            if(ceiling == null){
                ceiling = treeSet.last();
            }
            Integer floor = treeSet.floor(e);
            if(floor == null){
                floor = treeSet.first();
            }
            Integer start = treeMap.get(ceiling);
            Integer end = treeMap.get(floor);


            System.out.println(end - start + 1);
        }




    }
}