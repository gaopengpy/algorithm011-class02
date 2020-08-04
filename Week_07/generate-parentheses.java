class Solution {

	public List<String> resultList = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
		generate(0, 0, n, "");
		return resultList;
    }

	public void generate(int left, int right, int n, String s) {

		if (left == n && right == n) {
			System.out.println(s);
			resultList.add(s);
			return;
		}

		if (left < n) {
			generate(left + 1, right, n, s + "(");
		}

		if (left > right) {
			generate(left, right + 1, n, s + ")");
		}
	}    
}