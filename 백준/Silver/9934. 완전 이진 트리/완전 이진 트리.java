import java.io.*;
import java.util.StringTokenizer;

//완전 이진트리 중위순회
public class Main{

    static int K;
    static int[] arr;//트리 배열
    static StringBuffer[] ans;//트리 높이에 따른 노드들

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());//트리 높이
        //트리의 총 노드 개수 구해서 트리 배열의 크기
        arr = new int[(int) Math.pow(2, K) - 1];

        //입력한 숫자 트리 배열에 넣기
        st =new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        //트리 높이만큼 배열 크기 설정하고 각 원소에 StringBuffer 객체 넣기
        ans = new StringBuffer[K];
        for (int i = 0; i < K; i++)
            ans[i] = new StringBuffer();

        //0 6 0
        solve(0, arr.length - 1, 0);

        for (int i = 0; i < K; i++)
            //각 높이에 있는 트로 노드들 출력
            bw.write(ans[i].toString() + "\n");

        bw.flush();

    }

    //재귀 이용해 해결
    //트리의 높이를 크기로 하는 StringBuffer 배열을 생성하였다.
    //StringBuffer[] ans = new StringBuffer();
    //ans[0] : 트리의 첫번째 높이 -> 3
    //ans[1] : 트리의 두번째 높이 -> 6 2
    //ans[2] : 트리의 세번째 높이 -> 1 4 5 7
    //현재 노드가 트리의 몇층(floor)에 해당하는지를 넣어준 후, 
    //해당하는 노드의 번호를 ans[floor] 문자열 뒤에 추가
    public static void solve(int s, int e, int floor) {

        //파라미터로 들어온 층과 입력한 트리 높이 같으면 종료
        if (floor == K)
            return;
        
        //3
        int m = (s + e) / 2;
        
        //1층의 원소 3추가, arr[3]
        //루트 노드는 중앙에 있는
        ans[floor].append(arr[m] + " ");

        solve(s, m - 1, floor + 1);//0 2 1
        solve(m + 1, e, floor + 1);//4 6 1
    }
}