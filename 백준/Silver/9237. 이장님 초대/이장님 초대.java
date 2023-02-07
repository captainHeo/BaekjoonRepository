import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] t = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }
        // 오래걸리는거부터 심어야 최대한 빠르므로 역정렬
        Arrays.sort(t, Collections.reverseOrder());
        int maxDay = 0;
        for (int i = 0; i < N; i++) {
            // 나무자라는데걸리는시간 + 며칠지났는지 + 심는데 하루
            maxDay = Math.max(maxDay, t[i] + i + 1);
        }
        // 다 심은 다음날 이장님 초대 가능
        maxDay += 1;
        System.out.println(maxDay);
    }
}