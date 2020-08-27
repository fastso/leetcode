package q332;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
	Map<String, PriorityQueue<String>> map = new HashMap<>();
	List<String> itinerary = new LinkedList<>();

	public List<String> findItinerary(List<List<String>> tickets) {
		for (List<String> ticket : tickets) {
			String from = ticket.get(0), to = ticket.get(1);
			if (!map.containsKey(from)) {
				map.put(from, new PriorityQueue<>());
			}
			map.get(from).add(to);
		}
		dfs("JFK");
		Collections.reverse(itinerary);
		return itinerary;
	}

	public void dfs(String from) {
		while (map.containsKey(from) && map.get(from).size() > 0) {
			String tmp = map.get(from).poll();
			dfs(tmp);
		}
		itinerary.add(from);
	}
}