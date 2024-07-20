import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static ArrayList<Integer>[] list;
    static HashSet<Integer>[] groups;

    static boolean[] visited;

    static LinkedList<Integer> q;
    public static void main(String[] args) throws Exception {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();

        list = new ArrayList[n];
        groups = new HashSet[m];
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            groups[i] = new HashSet<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j=0; j<k; j++){
                int num = Integer.parseInt(st.nextToken()) - 1;
                // 그룹 i에 number 추가
                groups[i].add(num);
                // 현재 번호가 포함된 그룹들
                list[num].add(i);
            }
        }
        int count = 1;
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){

            // 초대를 받은 넘버
            // 그러면 1을 포함하고있는 모든 그룹에서 1을 제외시킨다.
            int inviteNumber = q.poll();

            for(int it : list[inviteNumber]){ // 내가 포함된 번호들에 들어가서 지운다.
                groups[it].remove(inviteNumber);
                if(groups[it].size() == 1){
                    Iterator<Integer> iterator = groups[it].iterator();
                    int nextInviteNumber = iterator.next();
                    if(!visited[nextInviteNumber]) {
                        visited[nextInviteNumber] = true;
                        q.add(nextInviteNumber);
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

    }
}