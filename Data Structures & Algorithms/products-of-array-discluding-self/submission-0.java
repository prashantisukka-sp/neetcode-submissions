class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        for (int i = 0, j = nums.length - 1; i < nums.length && j > -1; i++, j--) {
            prefix[i] = (i == 0 ? 1 : prefix[i - 1]) * nums[i];
            suffix[j] = (j == nums.length - 1 ? 1 : suffix[j + 1]) * nums[j];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = (i == 0 ? 1 : prefix[i - 1]) * (i == nums.length - 1 ? 1 : suffix[i + 1]);
        }
        return res;
    }
}  
