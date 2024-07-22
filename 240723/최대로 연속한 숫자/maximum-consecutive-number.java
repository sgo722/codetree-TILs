import java.util.*;
import java.io.*;
public class Main {
    static class Tuple implements Comparable<Tuple>{
        int len;
        int l;
        int r;

        public Tuple(int len, int l, int r) {
            this.len = len;
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Tuple t) {
            if(this.len != t.len){
                return t.len - this.len;
            }else if(this.l != t.l) {
                return this.l - t.l;
            }else{
                return this.r - t.r;
            }
        }
    }

    static int n,m;

    static TreeSet<Integer> sNum = new TreeSet<>();
    static TreeSet<Tuple> sLen = new TreeSet<>();
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sNum.add(-1);
        sNum.add(n + 1);
        sLen.add(new Tuple(n+1, -1, n+1));
        for(int i=0; i<m; i++){
            int y = sc.nextInt();

            sNum.add(y);

            Integer z = sNum.higher(y);
            Integer x = sNum.lower(y);

            sLen.remove(new Tuple(z - x - 1, x, z));
            sLen.add(new Tuple(y-x-1, x,y));
            sLen.add(new Tuple(z-y-1, y,z));

            System.out.println(sLen.first().len);
        }
    }
}