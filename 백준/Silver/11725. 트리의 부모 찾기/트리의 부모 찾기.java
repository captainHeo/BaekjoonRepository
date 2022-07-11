import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    static List<Integer>[] list;//정수 리스트 타입의 배열
    static boolean[] visit;
    static int n;
    static StringTokenizer st;

    //처음에 루트노드인 1 들어와 visit[1] = true
    private static void dfs(int v) {
        visit[v] = true;

        //해당 인덱스에 리스트에 있는 값들 하나씩 갖고와
        for(int i : list[v]) {
            //방문하지 않은 노드면 
            if(!visit[i]) {
                parents[i] = v;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        parents = new int[n+1];

        for(int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        visit = new boolean[n+1];

        for(int i = 0; i < n-1; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b); list[b].add(a);
        }

        dfs(1);

        //지금 노드와 연결되어 있는 노드들을 for문을 이용해 가져오고,
        //방문한적이 없으면 지금 노드가 부모 노드가 되고 연결되어 있는 노드가 자식 노드가 된다.
        //부모 노드를 자식 노드보다 항상 먼저 방문하기 때문이다.
        for(int i = 2; i <= n; i++)
            System.out.println(parents[i]);
    }
}
