import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;

    static int node, line, start;

    static Queue<Integer> q = new LinkedList<>();

    public static void main (String[]args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());//정점
        line = Integer.parseInt(st.nextToken());//간선 
        start = Integer.parseInt(st.nextToken());//시작 정점

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];//방문 체크 배열

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            //1 2면 2 1 이렇게 서로 연결된걸 넣어주는
            arr[a][b] = arr[b][a] = 1;
        }
        
        //sb.append("\n");
        //시작 정점으로 dfs 시작
        dfs(start);
        sb.append("\n");
        //dfs 시작 전 방문체크 초기화
        check = new boolean[node + 1];

        bfs(start);

        System.out.println(sb);

    }
    public static void dfs ( int start){

        //파라미터로 들어온 정점 방문 체크
        check[start] = true;
        sb.append(start + " ");

        //정점 개수만큼 반복
        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i])
                dfs(i);
        }

    }

    public static void bfs ( int start){
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {

            start = q.poll();
            sb.append(start + " ");

            for (int i = 1; i <= node; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }


    }

}

