import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static char[][] a,b;
    static HashSet<String> set;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = new char[n][m];
        b = new char[n][m];

        set = new HashSet<>();

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                a[i][j] = s.charAt(j);
            }
        }

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<m; j++){
                b[i][j] = s.charAt(j);
            }
        }

        int count = 0;
        for(int i=0; i<m-2; i++){
            for(int j=i+1; j<m-1; j++){
                for(int k=j+1; k<m; k++) {
                    set.clear();
                    for(int idx=0; idx<3; idx++) {
                        char[] chars = makeAChars(idx, i, j, k);
                        String s = Arrays.toString(chars);
                        set.add(s);
                    }


                    String b0String = Arrays.toString(makeBChars(0, i, j, k));
                    String b1String = Arrays.toString(makeBChars(1, i, j, k));
                    String b2String = Arrays.toString(makeBChars(2, i, j, k));

                    if (!set.contains(b0String) && !set.contains(b1String) && !set.contains(b2String)) {
                        count++;
//                        System.out.println(b0String + " " + b1String + " " + b2String);
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static char[] makeAChars(int index, int i, int j, int k) {
        char[] chars = new char[3];
        chars[0] = a[index][i];
        chars[1] = a[index][j];
        chars[2] = a[index][k];
        return chars;
    }

    private static char[] makeBChars(int index, int i, int j, int k) {
        char[] chars = new char[3];
        chars[0] = b[index][i];
        chars[1] = b[index][j];
        chars[2] = b[index][k];
        return chars;
    }
}