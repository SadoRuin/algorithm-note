import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    // 인접리스트에 기록할 노드 클래스
    static class Node {
        int vertex; // 정점 인덱스
        double weight;  // 가중치
        Node next;  // 다음 노드

        public Node(int vertex, double weight) {    // 우선순위큐에 넣을때 사용할 생성자
            this.vertex = vertex;
            this.weight = weight;
        }

        public Node(int vertex, double weight, Node next) { // 인접리스트를 만들때 사용할 생성자
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }

    static double E;    // 환경부담 세율

    // 환경 부담금 계산
    static double distance(int x1, int y1, int x2, int y2) {
        return E * Math.abs(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트케이스 개수
        for (int tc = 1; tc <= T; tc++) {   // 테스트케이스만큼 반복
            int N = Integer.parseInt(br.readLine());    // 섬의 개수
            int[] X = new int[N];   // 섬의 X좌표 모음
            int[] Y = new int[N];   // 섬의 Y좌표 모음
            String[] st1 = br.readLine().split(" ");    // X좌표 파싱
            String[] st2 = br.readLine().split(" ");    // Y좌표 파싱
            for(int i=0; i<N; i++) {
                X[i] = Integer.parseInt(st1[i]);
                Y[i] = Integer.parseInt(st2[i]);
            }
            E = Double.parseDouble(br.readLine());  // 환경 부담 세율 입력

            Node[] adjList = new Node[N];   // 노드 클래스로 인접리스트 생성
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {    // 이중 for문을 돌면 무향그래프의 인접리스트 완성
                    if(i == j) continue;    // 자기 자신이 목저지일 경우는 제외
                    adjList[i] = new Node(j, distance(X[i], Y[i], X[j], Y[j]), adjList[i]);
                }
            }

            double[] minEdge = new double[N];   // 각 정점 입장에서 신장트리에 포함된 정점과의 간선 비용중 최소비용
            boolean[] visited = new boolean[N]; // 신장트리에 포함 여부

            Arrays.fill(minEdge, Double.MAX_VALUE); // 최소값 관리하기 위해 큰 값 세팅

            minEdge[0] = 0; // 0번 정점을 신장트리 구성의 시작점으로
            double result = 0;  // 비용 누적 변수

            // 비용을 기준으로 오름차순 정렬로 우선순위큐 구성
            PriorityQueue<Node> pQueue = new PriorityQueue<>((v1, v2) -> Double.compare(v1.weight, v2.weight));
            pQueue.offer(new Node(0, minEdge[0])); // 시작점인 0번 정점 추가

            int cnt = 0;    // 신장트리에 추가된 정점의 수
            while(true) {
                Node minVertex = pQueue.poll(); // 최소 비용의 정점을 꺼냄

                if(visited[minVertex.vertex]) continue; // 방문 했었다면 버림
                visited[minVertex.vertex] = true;   // 방문 기록
                result += minVertex.weight; // 비용 누적
                if(++cnt == N) break;   // 추가된 정점 개수 상승하고 정점의 개수가 됐으면 무한루프 종료

                for(Node tmp = adjList[minVertex.vertex]; tmp != null; tmp = tmp.next) {    // 최소비용 정점과 연결된 모든 정점 탐색
                    if(!visited[tmp.vertex] && minEdge[tmp.vertex] > tmp.weight) {  // 방문하지 않았으면서 비용이 더 작은 연결이라면
                        minEdge[tmp.vertex] = tmp.weight;   // 최소비용을 갱신하고
                        pQueue.offer(new Node(tmp.vertex, minEdge[tmp.vertex]));    // 해당 정점을 우선순위큐에 새로 추가
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(Math.round(result)).append("\n");  // 최종 결과물 저장
        }

        System.out.println(sb); // 결과물 출력
    }
}
