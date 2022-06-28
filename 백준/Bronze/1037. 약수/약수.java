import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		while(T-- > 0) {
			int N = in.nextInt();
			max = N > max ? N : max;//입력받은 값이 max보다 크면 max로
			min = N < min ? N : min;

		}
		System.out.println(max * min);
		
	}
}
