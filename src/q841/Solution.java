package q841;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int num = 0;
		boolean[] visited = new boolean[rooms.size()];
		Queue<Integer> que = new LinkedList<Integer>();
		visited[0] = true;
		que.add(0);
		while (!que.isEmpty()) {
			int x = que.poll();
			num++;
			for (int it : rooms.get(x)) {
				if (!visited[it]) {
					visited[it] = true;
					que.offer(it);
				}
			}
		}
		return (num == rooms.size());
	}
}