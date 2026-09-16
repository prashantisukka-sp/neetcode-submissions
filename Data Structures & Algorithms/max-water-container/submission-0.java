class Solution {
    public int maxArea(int[] heights) {
        int max_area = 0, l = 0, r = heights.length - 1, area = 0;
        while (l < r) {
            area = Math.min(heights[l], heights[r]) * (r - l);
            max_area = Math.max(max_area, area);
            if (heights[l] > heights[r]) {
                r--;
            } else { 
                l++;
            }
        }
        return max_area;
    }
}
