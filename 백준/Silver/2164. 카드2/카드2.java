import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static LinkedList<Integer> ar = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {

            ar.addLast(i);
        }

        while(ar.size() != 1) {
            ar.removeFirst();
            ar.addLast(ar.removeFirst());
        }

        System.out.println(ar.getFirst());
    }
}
