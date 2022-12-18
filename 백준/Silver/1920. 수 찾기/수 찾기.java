import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//이진 탐색
public class Main {
    static int [] ar;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ar = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ar);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");


        for(int i=0; i<M; i++) {
            // 찾고자 하는 값이 있을 경우 1, 없을 경우 0을 출력해야한다.
            if(binarySearch(Integer.parseInt(st.nextToken())) >= 0) {
                sb.append(1).append('\n');
            }
            else {
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static int binarySearch(int key) {
        int left = 0;
        int right = ar.length-1;

        int mid;
        // lo가 hi보다 커지기 전까지 반복한다.
        while(left <= right) {

            // 반복문 시작할 때 중간위치를 구한다.
            mid = (left + right) / 2;

            //반복문 끝날 때 왼쪽 또는 오른쪽 위치 갱신한다

            // key값이 중간 위치의 값보다 작을 경우
            // 오른쪽 끝 범위를 중간위치 전으로
            if(key < ar[mid]) {
                right = mid - 1;
            }
            // key값이 중간 위치의 값보다 클 경우
            // 왼쪽 끝 범위를 중간위치 다음으로
            else if(key > ar[mid]) {
                left = mid + 1;
            }
            // key값과 중간 위치의 값이 같을 경우
            else {
                return mid;
            }
        }

        // 찾고자 하는 값이 존재하지 않을 경우
        return -1;
    }
}
