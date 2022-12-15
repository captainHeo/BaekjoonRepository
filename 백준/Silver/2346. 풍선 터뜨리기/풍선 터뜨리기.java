import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Balloon> q = new ArrayDeque<>();
        for(int i=1; i< n+1; i++) {
            q.offerLast(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        Balloon balloon = q.pollFirst();
        sb.append(balloon.index +" ");
        int nextBalloon = balloon.paperNum;

        while (!q.isEmpty()){
            if(nextBalloon > 0) {
                for(int j=0; j<nextBalloon-1; j++){
                    q.offerLast(q.pollFirst());
                }
                balloon = q.pollFirst();
                sb.append(balloon.index +" ");
                nextBalloon = balloon.paperNum;
            } else {
                for(int j=0; j<Math.abs(nextBalloon)-1; j++){
                    q.offerFirst(q.pollLast());
                }
                balloon = q.pollLast();
                sb.append(balloon.index +" ");
                nextBalloon = balloon.paperNum;
            }
        }
        System.out.println(sb);
    }

    static class Balloon {
        int index;
        int paperNum;

        public Balloon(int index, int paperNum) {
            this.index = index;
            this.paperNum = paperNum;
        }
    }
}
