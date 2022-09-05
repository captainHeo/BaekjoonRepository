import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main{

    static ArrayList<Node>[] list;//트리의 노드가 들어있는 배열
    static boolean[] visited;//방문 체크
    static int max = 0;
    static int node;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for(int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());//정점 번호

            while(true) {
                int e = Integer.parseInt(st.nextToken());//정점 번호와 떨어진 정점 번호
                if(e == -1)//-1 입력되면 반복 종료
                    break;
                int cost = Integer.parseInt(st.nextToken());//거리
                //정점 번호에 연결된 노드리스트에 떨어진 정점과 거리를 넣은 노드 객체를 추가
                list[s].add(new Node(e, cost));
            }
        }

        //임의의 노드(1)에서 부터 가장 먼 노드를 찾는다. 이때 찾은 노드를 node에 저장한다.
        visited = new boolean[n + 1];
        dfs(1, 0);

        //node에서 부터 가장 먼 노트까지의 거리를 구한다.
        visited = new boolean[n + 1];//다시 초기화
        dfs(node, 0);

        System.out.println(max);
    }

    //두 점 사이의 거리중 가장 긴 것
    //정점 1 거리 0으로 시작
    public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
            node = x;//가장 먼 노드
        }
        visited[x] = true;//해당 노드 방문 체크

        //트리 노드 개수만큼 반복
        //dfs에 들어온 임의의 노드에 연결된 노드들 하나씩 갖고와
        //방문했는지 확인하고
        //방문 안했으면 노드 번호와 dfs로 들어온 거리에
        //dfs로 들어온 노드와의 거리를 합쳐 dfs 시작
        for(int i = 0; i < list[x].size(); i++) {

            Node n = list[x].get(i);

            if(visited[n.e] == false) {
                dfs(n.e, n.cost + len);
                visited[n.e] = true;//방문 체크
            }
        }
    }

    public static class Node {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
    }
}

