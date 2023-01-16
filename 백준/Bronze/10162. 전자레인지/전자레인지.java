import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int [] button = {300, 60, 10};
        int [] count= new int[3];

        for(int i=0; i<3; i++) {

            //해당 버튼의 시간만큼 돌릴 수 있다면
            if(T/button[i] > 0) {
                //최대로 돌린 횟수 배열에 저장하고 나머지 시간 다시 T 에
                count[i] = T/button[i];
                T = T%button[i];
            }
        }

        if(T != 0 )
            System.out.println(-1);
        else
            System.out.println(count[0] + " " + count[1] + " " + count[2]);
    }
}
