import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        //testcase 및 문자열 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //문자열 담는 배열
        String [] ar = new String[n];
        //알파벳에 해당하는 숫자
        int [] alpha = new int[26];
        //문자열 담기
        for(int i=0; i<n; i++){
            ar[i] = br.readLine();
        }


        for(int i=0; i<n; i++){
            //해당 문자열 길이로 자릿수 구하기
            int temp = (int)Math.pow(10,ar[i].length()-1);

            //문자열 길이만큼 반복
            for(int j=0; j<ar[i].length(); j++){
                //문자에 해당하는 숫자에서 65 빼서 알파벳 순서 뽑기
                //해당 알파벳의 값에 자릿수 더하기
                alpha[(int)ar[i].charAt(j)-65]+=temp;
                temp /=10;
            }
        }

        //알파벳에 해당하는 숫자를 오름차순으로 정렬
        Arrays.sort(alpha);
        int index = 9;
        int sum =0;
        for(int i=alpha.length-1; i>=0; i--){
            if(alpha[i] == 0){
                break;
            }
            //저장된 자릿수와 인덱스 곱해 총합에 추가
            sum+= alpha[i]*index;
            index--;
        }
        System.out.println(sum);
    }
}