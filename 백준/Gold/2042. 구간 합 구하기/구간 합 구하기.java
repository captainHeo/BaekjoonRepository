import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static long[] input, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());//입력 숫자 횟수
        int M = Integer.parseInt(st.nextToken());//변경 횟수
        int K = Integer.parseInt(st.nextToken());//구간 합 횟수

        //세그먼트 트리 사이즈 지정
        tree=new long[N*4];

        //input[1]부터 저장한다. input의 인덱스 i는 트리에서 i번째 노드임을 뜻한다.
        //만약 0부터 시작하면 0의 자식노드가 0과 1이 되는 모순이 발생하므로 1부터 시작
        input=new long[N+1];

        //숫자를 배열에 대입
        for(int i=1;i<=N;i++)
            input[i]=Long.parseLong(br.readLine());

        init(1, 1, N); // 세그먼트 트리 생성

        for(int i=0;i<M+K;i++) {
            st=new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if(a==1) { // b번째를 c로 변경
                int b = Integer.parseInt(st.nextToken());//바꿀 위치 인덱스
                long c = Long.parseLong(st.nextToken());//변경될 값

                //조심해야 할 것은 input[b]도 c로 변경해야 한다는 것이다.
                //update에서 더해야 할 값 diff를 계산하기 위해 input 배열을 계속 확인하기 때문이다.
                //diff는 b번째 값(input[b])가 c이 되기 위해 더해야 하는 값
                long diff = c - input[b];

                input[b] = c;

                update(1, 1, N, b, diff);
            }

            else { // b~c 합 출력
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                System.out.println(sum(1, 1, N, b, c));
            }
        }

    }

    //node는 현재 노드 인덱스, left right는 현재 위치에서 구간 합 범위
    public static long init(int node, int left, int right) {
        //리프노드, 현재 위치(node)에 input[left]를 저장한다(left~right의 구간 합은 input[left]이므로).
        if(left == right)
            return tree[node] = input[left];

        //리프 노드가 아니라면 자식 노드(2i, 2i+1)를 재귀로 호출한다.
        //두 자식 노드의 구간 합이 tree[node]값
        int mid = (left + right) / 2;

        //재귀적으로 두 부분을 나눈뒤 그 합을 자기 자신
        //(node)번째 노드 합 = 왼쪽 자식(2*node) 합 + 오른쪽 자식(2*node+1) 합
        return tree[node] = init(2 * node, left, mid) + init(2 * node + 1, mid + 1, right);
    }

    //숫자 변경
    //now: 현재 노드 위치,  left right: 현재 노드의 합 범위, idx: 바꾸고자 하는 노드 인덱스, diff: 더할 값
    public static void update(int now, int left, int right, int idx, long diff) {

        //현재 위치에서 left right 구간 합 범위에 idx가 들어오지 않는다면 해당 노드는 수정할 필요가 없으므로 리턴한다.
        //아닐 경우 현재 노드에 diff만큼 더해서 값을 갱신한다.
        //현재 범위에 idx가 포함되지 않는다면 종료
        if(idx<left || idx>right)
            return;

        //현재 범위(left~right)에 idx가 포함되는 경우임
        tree[now]+=diff;

        //left!=right라면 아직 자식노드가 존재한다는 뜻이므로(리프노드가 아니므로) 자식노드 2i, 2i+1로 재귀 호출
        if(left!=right) { // 아직 탐색할 수 있는 범위가 더 있다면
            int mid=(left+right) / 2;

            update(2*now, left, mid, idx, diff);
            update(2*now+1, mid+1, right, idx, diff);
        }
    }

    //구간 합
    // now: 현재 노드 위치, left right: 현재 노드의 합 범위, rangeA rangeB: 찾아야 할 범위
    //따라서 처음으로 확인할 노드(루트 노드부터 시작) 1, 루트 노드의 구간 합 범위 1 N, 찾아야 할 구간 합 b c이므로 sum(1, 1, N, b, c)
    public static long sum(int now, int left, int right, int rangeA, int rangeB) {

        if(right<rangeA || left>rangeB)
            return 0; // 찾아야 할 범위를 벗어나면

        if(rangeA<=left && right<=rangeB)
            return tree[now]; // 찾아야 할 범위 안에 들어왔다면 현재 위치의 구간 합 리턴

        //걸쳐 있을 경우, 두 부분으로 나누어 합 구하기
        int mid=(left+right) / 2;
        
        return sum(2 * now, left, mid, rangeA, rangeB) + sum(2 * now+1, mid+1, right, rangeA, rangeB);
    }

}
