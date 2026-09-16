class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, k = 0; 
        while (j < m && k < n) {
            if (nums1[j] > nums2[k]) {
                temp[i++] = nums2[k++];
            } else {
                temp[i++] = nums1[j++];
            }
        }
        while (j < m) {
            temp[i++] = nums1[j++];
        }
        while (k < n) {
            temp[i++] = nums2[k++];
        }
        for (i = 0; i < (m + n); i++) {
            nums1[i] = temp[i];
        }
    }
}