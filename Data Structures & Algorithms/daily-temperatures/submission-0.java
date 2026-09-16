class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int[] res = new int[temps.length];
        Stack<int[]> s = new Stack();
        s.add(new int[]{temps[0], 0});
        for (int i = 1; i < temps.length; i++) {
            int val = temps[i];
            while (!s.isEmpty() && s.peek()[0] < val) {
                int[] top = s.pop();
                res[top[1]] = i - top[1];
            }
            s.add(new int[]{val, i});
        }
        return res;
    }
}
