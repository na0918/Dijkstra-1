package algorithmclass;

public class Dijkstra {
	//모든 변수들은 최대 정수값으로 초기화
	
	public void solve(int[][] graph, int point) {
		int distance[] = new int[graph[0].length];   // 주어지는 가중치 값에 따라 배열 동적 생성
		boolean check[] = new boolean[graph[0].length];   // 주어지는 가중치 값에 따라 배열 동적 생성
		
		//최소 거리를 담을 distance, 정점을 지났는지 확인 여부 check 배열 초기화
		for(int i=0; i<graph[0].length; i++) {
			distance[i] = Integer.MAX_VALUE;
			check[i] = false;
		}
		distance[point] = 0;  // 모두 MAX 값을 넣었기에 하나 정점을 0으로 만듬
		
		for(int count=0; count<graph[0].length; count++) {
			int u = minDistance(distance, check);
			check[u] = true;   
			
			// 알고리즘의 핵심 
			for(int j=0; j<graph[0].length; j++) {
				if(!check[j] && graph[u][j] !=0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][j] < distance[j]) {
					distance[j] = distance[u] + graph[u][j];
				}
			}
		}
		
		//최소거리 출력 반복문
		for(int j=0; j<distance.length; j++) {
			System.out.printf("%d  ", j);
		}
		System.out.println();
		for(int k=0; k<distance.length; k++) {
			System.out.printf("%d  ", distance[k]);
		}
	}
	
	// 다음 최소 거리를 가진 정점 탐색 메소드
	public int minDistance(int[] distance, boolean[] check) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		
		for(int i=0; i<distance.length; i++){
			if(check[i] == false && distance[i] <= min) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] {{0, 8, 0, 2, 4, 0},
    		                     {8, 0, 1, 4, 0, 2},
    		                     {0, 1, 0, 0, 0, 1},
    		                     {2, 4, 0, 0, 3, 7},
    		                     {4, 0, 0, 3, 0, 9},
    		                     {0, 2, 1, 7, 9, 0}};
		
		Dijkstra d = new Dijkstra();
		d.solve(graph, 0); // 경로상의 가중치의 값과 시작 정점입력
	}
}