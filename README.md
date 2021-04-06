# Dijkstra

Dijkstra Algorithm 은 음의 가중치가 없는 한 정점에서 모든 정점까지의 최단 거리를 구하는 알고리즘 입니다.

최종적으로 총 3개의 메소드로 이루어져 있습니다.

1. 다음 최소 거리(가중치)를 가진 정점을 찾는 메소드
2. 반복문을 통한 최단 거리 탐색 메소드
3. 메인 메소트

기본적인 설명은 코드에 주석으로 처리하였습니다.

~~~
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
~~~
반복문을 통해 모든 정점 까지의 최단 거리를 구하는 코드 입니다. 

~~~
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
~~~
다음으로 가중치가 가장 작은 정점을 찾는 코드 입니다.

이 코드는 배열로 구현하여 시간복잡도는 O(N^2) 입니다.
우선순위 큐로 구현을 할 경우 시간복잡도는 O(N * logN) 이며 이 것은 공부를 좀 더 하고난 후 비교해보겠습니다.
