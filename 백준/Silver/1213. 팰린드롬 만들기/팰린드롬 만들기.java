import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] alpha = new int[26];

        String s  = br.readLine();

        for(int i=0; i<s.length(); i++) {
            //해당 알파벳의 개수 증가
            alpha[s.charAt(i) - 'A']++;
        }

        //지역 변수. static 변수. 인스턴스 변수
        //인스턴스 변수에 static 이 붙으면 sttic 변수
        //지역 변수는 무조건 초기화해야 사용 가능
        int oddCount = 0;
        for(int i=0; i<alpha.length; i++) {
            if(alpha[i] %2 != 0) {
                oddCount++;
            }
        }
        String answer = "";
        StringBuilder sb = new StringBuilder();
        if(oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for(int i=0; i<alpha.length; i++) {
                //알파벳의 개수 절반만큼 빌더에 추가
                for(int j=0; j<alpha[i] / 2; j++) {
                    //현재 인덱스에 문자 A에 해당하는 아스키코드값 65 추가하고 캐스팅해서 빌더이ㅔ 추가
                   sb.append((char) (i + 65));
                }
            }
            //정답에 알파벳 추가
            answer = sb.toString();
            //추가한 알파벳의 뒤집은 결과 변수에 일단 저장하기
            String reverse = sb.reverse().toString();

            sb = new StringBuilder();
            for(int i=0; i<alpha.length; i++) {
                if(alpha[i]%2 != 0)
                    sb.append((char) (i + 65));
            }

            answer += sb.toString() + reverse;
        }

        System.out.println(answer);
    }
}