import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//각 자릿 수 합이 3의 배수, 입력받은 수에 0이 있어야함 30의 배수이니
public class Main {
    public static final int MAX = 100000;

    public static String N;
    public static int[] numCountArr;
    public static long strLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N는 최대 10의 5승개의 숫자로 구성, 
        N = br.readLine();
        
        strLen = N.length();
        //0~9?
        numCountArr = new int[10];
        //각 자리 숫자의 총합
        long total = 0;
        
        for(int i=0; i < strLen; i++) {
            int tNum = Integer.parseInt(N.substring(i, i+1));
            //각 자리 숫자에 해당하는 인덱스의 값에 1 추가
            numCountArr[tNum] += 1;
            total+=tNum;
        }

        // 0이 존재하지 않으면 30 배수 조차도 될 수 없다.
        // 각 자리수의 총 합이 3의 배수가 아니면 종료해야한다.
        if(!N.contains("0") || total % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            while(numCountArr[i] > 0) {
                sb.append(i);
                numCountArr[i]--;
            }
        }
        System.out.println(sb.toString());
    }
}
