import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //각 배열 원소는 Node 타입의 단순리스트
    static ArrayList<Node> list[] ;
    static int n;//노드 개수
    static int max = 0;
    static boolean visited[];
    static int max_idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());//긴산의 개수

        list = new ArrayList[n+1];//간선 배열

        for(int i=0; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());//부모노드
            int child = Integer.parseInt(st.nextToken());//자식노드
            int weight = Integer.parseInt(st.nextToken());//가중치

            list[parent].add(new Node(child, weight));
            list[child].add(new Node(parent, weight));
        }

        visited = new boolean[n+1];//밤문 체크 배열
        visited[1] = true;//루트노드 1 방문 체크
        dfs(1,0);//1부터 시작
        //위에서 방문체크하고 최대 지름길이 max 구하기
        
        visited = new boolean[n+1];//방문 체크 배열 다시 대입
        visited[max_idx] = true;//최대 노드 값 방문
        dfs(max_idx,0);
        System.out.println(max);

    }

    //1, 0
    public static void dfs(int idx, int cnt) {

        if(max < cnt) {
            max = cnt;
            max_idx = idx;
        }

        //노드 배열에서 노드 꺼내
        for(Node a : list[idx]) {
            
            //노드의 번호, 해당 노드 방문하지 않았다면 방문 체크 후
            //dfs 에 넣기, 가중치는 현재 들어온 가중치에 더해, 가중치 더해 최대값 구하기 때문
            if(!visited[a.idx]) {
                visited[a.idx] = true;
                dfs(a.idx, cnt + a.cnt);
            }
        }

    }
}
class Node{

    int idx, cnt;
    //번호, 가중치
    Node(int idx, int cnt){
        this.idx = idx;
        this.cnt = cnt;
    }
}
