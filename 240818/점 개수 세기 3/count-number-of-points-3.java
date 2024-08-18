import java.io.*;
import java.util.*;

public class Main{

    static TreeMap<Integer, Integer> treeMap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        treeMap = new TreeMap<>();

        int n = sc.nextInt();
        int q = sc.nextInt();

        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            treeMap.put(num,i+1);
        }

        for(int i=0; i<q; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            Integer floorKey = treeMap.ceilingKey(s);
            Integer ceilingKey = treeMap.floorKey(e);
            Integer startCount = treeMap.get(floorKey);
            Integer endCount = treeMap.get(ceilingKey);
            System.out.println(endCount - startCount + 1);
        }
    }
}