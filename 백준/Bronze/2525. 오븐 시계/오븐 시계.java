import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        int addMinute = Integer.parseInt(br.readLine());

        minute+=addMinute;

        int addHour, minusMinute;
        //더한 시간에서 분이 60이상이면
        if(minute >= 60) {
            //분을 60으로 나누어 더할 시간 계산
            addHour = minute / 60;
            //시간 더하기
            hour += addHour;

            //더한 시간만큼 분 빼주기
            minute -= addHour * 60;

            if(hour >= 24) {
                hour -= 24;
            }
        }

        System.out.println(hour + " " + minute);
    }
}
