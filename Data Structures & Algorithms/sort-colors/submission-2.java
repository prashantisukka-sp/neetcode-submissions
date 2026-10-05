class Solution {
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int n: nums) {
            counts[n]++;
        }
        int i = 0;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < counts[j]; k++) {
                nums[i++] = j;
            }
        }
    }
}