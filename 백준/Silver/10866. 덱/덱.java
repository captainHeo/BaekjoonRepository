import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        //입력 횟수
        int N = Integer.parseInt(br.readLine());

        //입력 횟수만큼 반복
        while (N-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {

                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_back":
                    sb.append(pop_back()).append("\n");
                    break;

                case "pop_front":
                    sb.append(pop_front()).append("\n");
                    break;

                case "size":
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "front":
                    sb.append(front()).append('\n');
                    break;

                case "back":
                    sb.append(back()).append('\n');
                    break;
            }
        }

        System.out.println(sb);
    }

    //맨 앞 삽입
    public static void push_front (int item) {

        deque.addFirst(item);
    }

    //맨 뒤 삽입
    public static void push_back (int item) {

        deque.addLast(item);
    }

    //맨 앞 제거
    public static int pop_front () {
        if (deque.isEmpty())
            return -1;
        else
            return deque.removeFirst();
    }

    //맨 뒤 제거
    public static int pop_back () {
        if (deque.isEmpty())
            return -1;
        else
            return deque.removeLast();
    }

    public static int size () {

        return deque.size();
    }

    public static int empty () {

        if (deque.isEmpty())
            return 1;
        else
            return 0;
    }

    //맨 앞 원소
    public static int front () {

        if (deque.isEmpty())
            return -1;
        else
            return deque.getFirst();
    }

    //맨 뒤 원소
    public static int back () {

        if (deque.isEmpty())
            return -1;
        else
            return deque.getLast();
    }
}
