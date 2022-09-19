import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//물 새는 위치 수
        int L = Integer.parseInt(st.nextToken());//테이프 길이

        int water[] = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(water);

        //테이프 처음 붙인 지점
        double left = water[0] - 0.5;

        int cnt = 1;

        //물 새는 위치 수만킄 반복
        for(int i=0; i<N; i++) {
            
            //테이프를 붙인 지점이 물 새는 지점보다 작다면 테이프 추가
            if(left + L < water[i]) {
                cnt++;
                left = water[i] - 0.5;
            }
        }

        System.out.println(cnt);
    }
}
