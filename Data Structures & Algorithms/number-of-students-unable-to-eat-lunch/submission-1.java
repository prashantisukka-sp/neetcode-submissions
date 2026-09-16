class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] cnt = new int[2];
        for (int s: students) {
            cnt[s]++;
        }
        for (int sandwich: sandwiches) {
            if (cnt[sandwich] > 0) {
                cnt[sandwich]--;
            } else {
                break;
            }
        }
        return cnt[0] + cnt[1];
    }
}