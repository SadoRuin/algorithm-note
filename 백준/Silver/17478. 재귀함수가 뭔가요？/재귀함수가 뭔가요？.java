import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int n;
	static BufferedWriter bw;
	
	public static void recursive(int cnt) throws IOException {
		if(n == cnt) {
			for(int i=0; i<cnt*4; i++) {
				bw.write("_");
			}
			bw.write("\"재귀함수가 뭔가요?\"\n");
			for(int i=0; i<cnt*4; i++) {
				bw.write("_");
			}
			bw.write("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			for(int i=0; i<cnt*4; i++) {
				bw.write("_");
			}
			bw.write("라고 답변하였지.\n");
			return;
		}
		for(int i=0; i<cnt*4; i++) {
			bw.write("_");
		}
		bw.write("\"재귀함수가 뭔가요?\"\n");
		for(int i=0; i<cnt*4; i++) {
			bw.write("_");
		}
		bw.write("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		for(int i=0; i<cnt*4; i++) {
			bw.write("_");
		}
		bw.write("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		for(int i=0; i<cnt*4; i++) {
			bw.write("_");
		}
		bw.write("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		
		recursive(cnt+1);
		
		for(int i=0; i<cnt*4; i++) {
			bw.write("_");
		}
		bw.write("라고 답변하였지.\n");
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		int cnt = 0;
		bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		recursive(cnt);
		
		bw.flush();
		bw.close();
		br.close();
		

	}

}