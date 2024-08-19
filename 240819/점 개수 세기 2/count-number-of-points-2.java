import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main{
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Square{
        int x1,y1,x2,y2;

        public Square(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    static TreeSet<Integer> numbers;
    static Point[] points;
    static Square[] squares;
    static HashMap<Integer, Integer> mapper;
    static int[][] prefixSum;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        prefixSum = new int[5002][5002];
        numbers = new TreeSet<>();
        mapper = new HashMap<>();


        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        points = new Point[n+1];
        squares = new Square[n+1];


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Point(x,y);
            numbers.add(x);
            numbers.add(y);
        }

        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            squares[i] = new Square(x1,y1,x2,y2);
        }

        int count = 1;
        for(int number : numbers){
            mapper.put(number, count);
            count++;
        }

        for(int i=0; i<n; i++){
            int x = points[i].x;
            int y = points[i].y;

            int newX = mapper.get(x);
            int newY = mapper.get(y);

            prefixSum[newX][newY]++;
        }

        for(int i=1; i<=count; i++){
            for(int j=1; j<=count; j++){
                prefixSum[i][j] = prefixSum[i][j] + prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1];
            }
        }


        for(int i=0; i<q; i++){
            int x1 = squares[i].x1;
            int y1 = squares[i].y1;
            int x2 = squares[i].x2;
            int y2 = squares[i].y2;

            int newX1 = getLowerBoundary(x1);
            int newY1 = getLowerBoundary(y1);
            int newX2 = getUpperBoundary(x2);
            int newY2 = getUpperBoundary(y2);

            int ans = getSum(newX1, newY1, newX2, newY2);
            System.out.println(ans);
        }
    }

    static int getUpperBoundary(int number){
        if(numbers.floor(number) != null){
            return mapper.get(numbers.floor(number));
        }
        return 0;
    }

    static int getLowerBoundary(int number){
        if(numbers.ceiling(number) != null){
            return mapper.get(numbers.ceiling(number));
        }
        return numbers.size()+1;
    }

    static int getSum(int x1, int y1, int x2, int y2){
        return prefixSum[x2][y2] - prefixSum[x1 - 1][y2]
                - prefixSum[x2][y1-1] + prefixSum[x1 - 1][y1 - 1];
    }
}