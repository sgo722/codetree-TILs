import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int n,g;
    static HashSet<Integer>[] groups;
    static boolean[] invited;
    static ArrayList<Integer>[] peopleGroups;
    static Queue<Integer> q = new LinkedList<>();
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        groups = new HashSet[g];
        invited = new boolean[n+1];
        peopleGroups = new ArrayList[n+1];

        for(int i=0; i<n; i++){
            peopleGroups[i] = new ArrayList<>();
        }

        for(int i=0; i<g; i++){
            groups[i] = new HashSet<>();
        }

        for(int i=0; i<g; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++){
                int x = Integer.parseInt(st.nextToken()) - 1;
                groups[i].add(x);
                peopleGroups[x].add(i);
            }
        }

        q.add(0);
        invited[0] = true;

        while(!q.isEmpty()){
            int x = q.poll();
            ans++;

            for(int i=0; i< peopleGroups[x].size(); i++){
                int gNum = peopleGroups[x].get(i);

                groups[gNum].remove(x);

                if(groups[gNum].size() == 1) {
                    int pNum = new ArrayList<>(groups[gNum]).get(0);
                    if(!invited[pNum]){
                        invited[pNum] = true;
                        q.add(pNum);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}