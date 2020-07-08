class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length]; // 标记访问过的元素，默认都是false
        backtrack(list, new ArrayList<Integer>(), nums, visited);
        return list;
    }

    public static void backtrack(
        List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] visited) {

        if (tempList.size() == nums.length) {
        list.add(new ArrayList<>(tempList));
        return;
        }

        for (int i = 0; i < nums.length; i++) {
        if (visited[i]) {
            continue; // 如果这个元素使用过了，就不再加入进去
        }

        if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
            continue;
        }

        visited[i] = true;
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, visited);
        visited[i] = false;
        tempList.remove(tempList.size() - 1);
        }
    }

}
