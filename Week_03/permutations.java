class Solution {

    public List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        int[] visited = new int[nums.length];
        backtrack(new ArrayList<>(), nums, visited);
        return output;

    }

    private void backtrack(List<Integer> temp, int[] nums, int[] visited) {
        if (temp.size() == nums.length) {
        output.add(new ArrayList<>(temp));
        return;
        }

        for (int i = 0; i < nums.length; i++) {
        if (visited[i] == 1) {
            continue;
        }
        visited[i] = 1;
        temp.add(nums[i]);
        backtrack(temp, nums, visited);
        visited[i] = 0;
        temp.remove(temp.size() - 1);
        }
    }
}



