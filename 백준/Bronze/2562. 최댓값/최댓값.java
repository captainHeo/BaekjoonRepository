import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> ar = new ArrayList<>();

        for(int i=0; i<9; i++) {

            ar.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(Collections.max(ar));
        System.out.println(ar.indexOf(Collections.max(ar)) + 1);
    }
}
