import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, D, K, C;
    static int[] arr, visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new int[N];

        //초밥 번호 담기
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        //번호마다 먹은 스시 개수를 저장할 배열 (먹었던 것을 또 먹은 경우에는 +1을 해주면 안되므로)
        visited = new int[D + 1];

        System.out.println(slide());
    }

    static int slide() {
        //inSlide 는 k 크기의 슬라이드 내에서 먹은 중복없는 스시 개수,
        //chance는 찬스까지 고려해 먹을 수 있는 개수
        int inSlide = 0, chance;

        //일단 처음 k개의 슬라이드에 담기
        for (int i = 0; i < K; i++) {

            //먹은 초밥의 번호를 인덱스로
            //처음 먹은 초밥이면 증가
            if (visited[arr[i]] == 0) {
                inSlide++;
            }

            //먹은 초밥인거 체크
            visited[arr[i]]++;        }

        chance = inSlide;

        for (int i = 1; i < N; i++) {

            // 슬라이드에 찬스 번호가 들어있지 않으면 1개 더 먹을 수 있다
            if (chance <= inSlide) {
                //먹은 초밥 아니면 더 먹을 수 있으니 1 추가
                if (visited[C] == 0) {
                    chance = inSlide + 1;
                } else {
                    chance = inSlide;
                }
            }

            // 슬라이드 이동 시, 앞쪽 스시는 못먹게 되고, 한번도 먹은적이 없다면 슬라이드 내에서 먹은 스시 개수 -1
            visited[arr[i - 1]]--;
            
            if (visited[arr[i - 1]] == 0) {
                inSlide--;
            }

            // 슬라이드 이동 시, 뒤쪽 스시 먹게 되고, 한번도 먹은적 없다면 슬라이드 내에서 먹은 스시 개수 +1
            // 회전초밥은 회전하므로 % n 을 사용해야한다
            if (visited[arr[(i + K - 1) % N]] == 0) {
                inSlide++;
            }
            visited[arr[(i + K - 1) % N]]++;
        }
        return chance;
    }
}