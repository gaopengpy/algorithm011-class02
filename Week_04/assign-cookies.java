class Solution {
    public int findContentChildren(int[] g, int[] s) {
		if (g == null || s == null) return 0;

		Arrays.sort(g);
		Arrays.sort(s);

		int j = 0;

		for (int i = 0; i < s.length; i++) {
		  int cookie = s[i];
		  if (cookie >= g[j]) {
			j++;
			if (j >= g.length) {
			  return j;
			}
		  }
		}

		return j;
    }
}