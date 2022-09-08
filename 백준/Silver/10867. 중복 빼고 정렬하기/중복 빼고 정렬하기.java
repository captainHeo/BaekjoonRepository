import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {

            set.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList ar = new ArrayList(Arrays.asList(set.toArray()));
        Collections.sort(ar);

        for(int i=0; i<ar.size(); i++) {

            sb.append(ar.get(i) + " ");
        }

        System.out.println(sb);
    }
}
