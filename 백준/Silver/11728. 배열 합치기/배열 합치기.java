import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
//        ArrayList<Integer> ar = new ArrayList<>();
        int ar[];
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int arSize = Integer.parseInt(st.nextToken());
        int arSize2 = Integer.parseInt(st.nextToken());
        ar = new int[arSize + arSize2];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<arSize; i++) {

//            ar.add(Integer.parseInt(st.nextToken()));
            ar[i] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine(), " ");
        for(int i=arSize; i<arSize + arSize2; i++) {

            ar[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ar);

        for(int i=0; i<ar.length; i++) {

            sb.append(ar[i] + " ");
        }
        System.out.println(sb);
    }
}
