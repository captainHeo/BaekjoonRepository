import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); 
        }

        for(int i = n-2; i >= 0; i--) {

            if(arr[i] >= arr[i+1]) {
                int diff = arr[i] - arr[i+1] + 1; 
                answer += diff;
                arr[i] -= diff;
            }
        }

        System.out.println(answer);
    }
}

