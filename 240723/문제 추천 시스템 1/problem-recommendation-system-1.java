import java.io.*;
import java.util.*;

public class Main{
    static class Problem implements Comparable<Problem>{
        int number;
        int difficulty;

        public Problem(int number, int difficulty) {
            this.number = number;
            this.difficulty = difficulty;
        }

        @Override
        public String toString() {
            return String.valueOf(number);
        }

        @Override
        public int compareTo(Problem o) {
            if(this.difficulty == o.difficulty){
                return this.number - o.number;
            }
            return this.difficulty - o.difficulty;
        }
    }

    static TreeSet<Problem> problems;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        problems = new TreeSet<>();
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            problems.add(new Problem(number, difficulty));
        }

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if(op.equals("ad")){
                int number = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());
                problems.add(new Problem(number, difficulty));

            }else if(op.equals("sv")){
                int number = Integer.parseInt(st.nextToken());
                int difficulty = Integer.parseInt(st.nextToken());
                problems.remove(new Problem(number, difficulty));

            }else if(op.equals("rc")){
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){
                    System.out.println(problems.last());
                }else if(x == -1){
                    System.out.println(problems.first());
                }
            }
        }


    }
}