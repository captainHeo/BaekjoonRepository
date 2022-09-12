import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, delete;
    static int[] parent;
    static int count;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        parent = new int[n];

        int root = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            //각 노드의 부모를 입력받음
            //-1을 입력받으면 부모가 없는거니까 루트노드
            //0이면 부모노드가 0
            parent[i] = Integer.parseInt(st.nextToken());

            //-1이면 부모가 없는것이니 루트로
            //먼저 배열에 값 넣고 루트노드인지 체크
            if(parent[i] == -1)
                root = i;
        }
        //삭제할 노드의 번호
        delete = Integer.parseInt(br.readLine());

        //삭제할 노드 연산
        deleteNode(delete);

        count = 0;
        visited = new boolean[n];
        //리프노드 연산, 루트노드 번호 넣음
        countLeaf(root);

        System.out.println(count);
    }

    //삭제할 노드의 번호 들어옴
    public static void deleteNode(int d) {
        //삭제된 노드 값 -2로 표시, 
        //노드의 번호가 배열의 인덱스고
        //노드의 부모 노드 번호는 배열의 원소값
        //우선 삭제할 노드 번호의 값이 부모 노드의 번호니까 -2로
        parent[d] = -2;

        //노드 개수만큼 반복
        for(int i = 0; i < n; i++) {
            
            //삭제할 노드의 번호를 부모로 갖고있는 노드들 똑같이 메서드 수행
            if(parent[i] == d) {
                deleteNode(i);
            }
        }
    }

    public static void countLeaf(int s) {
        boolean isLeaf = true;
        
        //파라미터로 들어온 번호 방문 체크
        visited[s] = true;
        
        //삭제된 노드가 아닌지 체크
        if(parent[s] != -2) {
            
            for(int i = 0; i < n; i++) {
                
                //부모 노드 값이 파라미터로 들어온 번호고 방문하지 않았다면
                if(parent[i] == s && visited[i] == false) {
                    countLeaf(i);
                    isLeaf = false;
                }
            }
            
            if(isLeaf) 
                count++;
        }
    }
}

