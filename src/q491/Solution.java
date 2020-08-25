package q491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<Integer> subsequence;
		List<List<Integer>> ans = new ArrayList<>();
		Set<Integer> set = new HashSet<>();

		int base = 263;
		int mod = 1000000007;
		int n = nums.length;
		for (int i = 0; i < (1 << n); ++i) {
			subsequence = findSubsequence(i, nums);
			int hashValue = getHashValue(subsequence, base, mod);
			if (isIncreasing(subsequence) && !set.contains(hashValue)) {
				ans.add(new ArrayList<>(subsequence));
				set.add(hashValue);
			}
		}
		return ans;
	}

	private List<Integer> findSubsequence(int mask, int[] nums) {
		List<Integer> subsequence = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if ((mask & 1) != 0) {
				subsequence.add(nums[i]);
			}
			mask >>= 1;
		}
		return subsequence;
	}

	private int getHashValue(List<Integer> target, int base, int mod) {
		int hashValue = 0;
		for (int x : target) {
			hashValue = hashValue * base % mod + (x + 101);
			hashValue %= mod;
		}
		return hashValue;
	}

	private boolean isIncreasing(List<Integer> list) {
		for (int i = 1; i < list.size(); ++i) {
			if (list.get(i) < list.get(i - 1)) {
				return false;
			}
		}
		return list.size() >= 2;
	}
}