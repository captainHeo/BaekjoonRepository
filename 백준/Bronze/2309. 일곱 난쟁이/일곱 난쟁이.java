import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ar = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            ar[i] = Integer.parseInt(br.readLine());
            sum += ar[i];
        }
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                //총합에서 2명 난쟁이 키 빼줘서 100 되면
                //인덱스에 해당하는 값 0으로
                if (sum - ar[i] - ar[j] == 100) {
                    ar[i] = 0;
                    ar[j] = 0;
                    //정렬해주고
                    Arrays.sort(ar);
                    //3번쨰 요소부터 출력
                    for (int k = 2; k < 9; k++) {
                        System.out.println(ar[k]);
                    }
                    return;
                }
            }
        }
    }
}