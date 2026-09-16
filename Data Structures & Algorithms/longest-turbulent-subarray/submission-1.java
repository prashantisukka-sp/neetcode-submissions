class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int l = 0, len = 1;
        String last_sign = "";
        for (int r = 1; r < arr.length; r++) {
            if (arr[r - 1] < arr[r] && (last_sign == "less" || last_sign == "")) {
                last_sign = "greater";
            } else if (arr[r - 1] > arr[r] && (last_sign == "greater" || last_sign == "")) {
                last_sign = "less";
            } else if (arr[r - 1] == arr[r]) {
                l = r;
                last_sign = "";
            } else {
                l = r - 1;
            }
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}