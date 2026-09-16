class KthLargest {
    PriorityQueue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue();
        for (int n: nums) {
            q.add(n);
            if (q.size() > k) {
                q.poll();
            } 
        }
    }
    
    public int add(int val) {
        q.add(val);
        if (q.size() > k) {
            q.poll();
        }
        return q.peek();
    }
}
