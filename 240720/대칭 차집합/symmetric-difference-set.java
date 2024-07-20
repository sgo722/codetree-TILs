import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main{
    static int n,m;
    static HashSet<Integer> groupA, groupB;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        groupA = new HashSet<>();
        groupB = new HashSet<>();

        for(int i=0; i<n; i++){
            groupA.add(Integer.parseInt(st.nextToken()));
        }


        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            groupB.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        Iterator<Integer> itA = groupA.iterator();
        Iterator<Integer> itB = groupB.iterator();
        while(itA.hasNext()){
            if(groupB.contains(itA.next())){
                continue;
            }
            count++;
        }


        while(itB.hasNext()){
            if(groupA.contains(itB.next())){
                continue;
            }
            count++;
        }


        System.out.println(count);


    }
}