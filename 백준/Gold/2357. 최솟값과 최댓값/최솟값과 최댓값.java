import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, minTree, maxTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //정수 개수
        int N = Integer.parseInt(st.nextToken());
        //최소 최대 구간 개수
        int M = Integer.parseInt(st.nextToken());

        //배열 생성하고
        //정수 배열에 저장
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //minInit에서는 구간 별로 최솟값을 minTree에 저장하고,
        //maxInit에서는 구간 별로 최댓값을 maxTree에 저장합니다.
        //이후, minFind과 maxFind라는 메소드를 정의하여 특정 구간 내에 최솟값과 최댓값을 찾도록 설계
        minTree = new int[N * 4];//최솟값 트리 배열
        maxTree = new int[N * 4];//최대값 트리 배열

        minInit(1, N, 1);//최솟값 트리 구현
        maxInit(1, N, 1);//최대값 트리 구현

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            //a번쨰 b번째
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            //최솟값 최대값 추가
            sb.append(minFind(1, N, 1, left, right) + " " + maxFind(1, N, 1, left, right) + "\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    //1, 10 ,1
    //각 구간 별로 최솟값을 저장.
    public static int minInit(int start, int end, int node) {
        //시작과 끝 같으면 입력한 정수 배열 첫번째 원소 최솟값 트리에 대입
        if (start == end) {
            return minTree[node] = arr[start];
        }

        //시작과 끝 다르면
        //중간값 생성
        int mid = (start + end) / 2;

        //최솟값 트리에 대입
        return minTree[node] = Math.min( minInit(start, mid, node * 2), minInit(mid + 1, end, node * 2 + 1));
    }

    //1, 10 ,1
    //각 구간 별로 최댓값을 저장.
    public static int maxInit(int start, int end, int node) {
        //시작과 끝 같으면 입력한 정수 배열 첫번째 원소 최솟값 트리에 대입
        if (start == end) {
            return maxTree[node] = arr[start];
        }

        int mid = (start + end) / 2;

        return maxTree[node] = Math.max( maxInit(start, mid, node * 2), maxInit(mid + 1, end, node * 2 + 1));
    }

    // left ~ right 범위 내에 최솟값을 찾음.
    //start node는 1로 고정
    //end는 N
    //left와 right가 a b
    //1 10 1 3 5
    public static int minFind(int start, int end, int node, int left, int right) {
        // 범위를 벗어난 경우
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        }

        // 범위 안에 있는 경우
        if (left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;

        return Math.min( minFind(start, mid, node * 2, left, right), minFind(mid + 1, end, node * 2 + 1, left, right));
    }

    // left ~ right 범위 내에 최댓값을 찾음.
    public static int maxFind(int start, int end, int node, int left, int right) {
        // 범위를 벗어난 경우
        if (right < start || end < left) {
            return Integer.MIN_VALUE;
        }

        // 범위 안에 있는 경우
        if (left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;

        return Math.max( maxFind(start, mid, node * 2, left, right), maxFind(mid + 1, end, node * 2 + 1, left, right));
    }

}
