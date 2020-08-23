package q201;

class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		// Brian Kernighan's Algorithm
		while (n > m) {
			n = n & (n - 1);
		}
		return n;
	}
}