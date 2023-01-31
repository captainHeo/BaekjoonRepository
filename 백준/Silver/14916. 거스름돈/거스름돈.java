import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int change = Integer.parseInt(br.readLine());

        int count = 0;

        //거스름돈이 남아있다면
        while (change>0) {
            //5로 딱 나뉘어 떨어지면
            if (change%5 ==0 ) {
                count = change/5 + count;
                break;
            }

            //5로 나뉘지 않으면 2씩 빼고 동전 개수 추가
            change -=2;
            count++;
        }

        //거슬러줄 수 없으면 거스름돈이 음수가 된다
        if (change < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}