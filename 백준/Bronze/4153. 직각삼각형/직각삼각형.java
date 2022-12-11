import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int[] ar;

        while(true) {
            st = new StringTokenizer(br.readLine());

            ar = new int[3];
            for(int i=0; i<3; i++) {
                ar[i] = Integer.parseInt(st.nextToken());
            }

            if(ar[0] ==0 && ar[0] ==0 && ar[0] ==0)
                break;

            Arrays.sort(ar);

            if(Math.pow(ar[0], 2) + Math.pow(ar[1], 2) == Math.pow(ar[2], 2)) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }

        System.out.println(sb);
    }
}
