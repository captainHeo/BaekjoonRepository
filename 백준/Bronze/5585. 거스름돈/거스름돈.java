import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(br.readLine());

        //거스름돈
        int remainedPrice = 1000 - price;

        //동전 배열
        int[] coinArr = {500, 100, 50, 10, 5, 1};

        //동전 개수
        int count =0;

        for(int i=0; i<6; i++){
            //거스름돈을 해당 동전으로 나누었을 때 나누어 떨어지면
            if(remainedPrice/coinArr[i]>0){
                //동전 개수 추가
                count += remainedPrice/coinArr[i];
                //해당 동전으로 나눈 나머지 대입
                remainedPrice %= coinArr[i];
            }
        }

        System.out.println(count);
    }
}
