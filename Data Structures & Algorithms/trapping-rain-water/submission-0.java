class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int lmax = height[l], rmax = height[r];
        int totalArea = 0;
        while (l < r) {
            if (lmax < rmax) {
                l++;
                lmax = Math.max(lmax, height[l]);
                totalArea += lmax - height[l];
            } else {
                r--;
                rmax = Math.max(rmax, height[r]);
                totalArea += rmax - height[r];
            }
        }
        return totalArea;
    }
}
