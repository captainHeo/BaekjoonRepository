import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int sum=0;

        for(int i=0; i<1000; i++) {
            //i의 크기만큼 반복해 i 를 리스트에 추가
            for(int j=0; j<=i; j++) {
                list.add(i + 1);
            }
        }

        for(int i=a-1; i<=b-1; i++) {
            sum += list.get(i);
        }

        System.out.println(sum);
    }
}