class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        cum_sum = 0
        l = 0
        cnt = 0;
        for r in range(len(arr)):
            if ((r - l + 1) > k):
                cum_sum -= arr[l]
                l += 1
            cum_sum += arr[r]
            if r - l + 1 == k and cum_sum / k >= threshold:
                cnt += 1
        return cnt;

        