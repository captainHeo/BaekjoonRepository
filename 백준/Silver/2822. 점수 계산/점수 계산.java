import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> ar = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<8; i++) {
            ar.add(Integer.parseInt(br.readLine()));
            map.put(ar.get(i), i+1);
        }

        Collections.sort(ar, Collections.reverseOrder());

        int sum =0;
        for(int i=0; i<5; i++) {
            sum += ar.get(i);
            ar2.add(map.get(ar.get(i)));
        }
        Collections.sort(ar2);
        for(int i=0; i<5; i++) {
            sb.append(ar2.get(i) + " ");
        }
        System.out.println(sum + "\n" + sb);
    }
}
