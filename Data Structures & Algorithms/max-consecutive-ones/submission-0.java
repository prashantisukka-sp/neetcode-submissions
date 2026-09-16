class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
     int max = 0, tempMax = 0;
     for (int i: nums) {
        if (i == 1) {
            tempMax++;
        } else {
            max = Math.max(max, tempMax);
            tempMax = 0;
        }
     }
     max = Math.max(max, tempMax);
     return max;   
    }
}