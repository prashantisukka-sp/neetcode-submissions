class NumArray {
    int[] prefix_sum;

    public NumArray(int[] nums) {
        prefix_sum = new int[nums.length];
        int total = 0, l = 0;
        for (int n: nums) {
            total += n;
            prefix_sum[l++] = total;
        }
    }
    
    public int sumRange(int left, int right) {
        return prefix_sum[right] - (left == 0 ? 0 : prefix_sum[left - 1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */