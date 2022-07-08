import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        //큐 우선순위를 가장 작은 값 순서대로
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0 ; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(queue.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(queue.poll());
            }else{
                queue.add(x);
            }
        }
    }
}
