/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
// import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String[] st = br.readLine().split(" ");
			int N = Integer.parseInt(st[0]);
			int M = Integer.parseInt(st[1]);
			
			int[] snack = new int[N];
			int[] pick = new int[2];
			st = br.readLine().split(" ");
			for(int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(st[i]);
			}
			max = 0;
			
			comb(snack, pick, N, M, 0, 0);
			if(max == 0) {
				max = -1;
			}
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		
		System.out.println(sb);

	}
	
	static void comb(int[] snack, int[] pick, int N, int M, int cnt, int start) {
		
		if(cnt == 2) {
			int sum = 0;
			for (int p : pick) {
				sum += p;
			}
			if(sum <= M) {
				max = Math.max(max, sum);
			}
			return;
		}
		
		for(int i=start; i<N; i++) {
			pick[cnt] = snack[i];
			comb(snack, pick, N, M, cnt+1, i+1);
		}
		
	}

}
