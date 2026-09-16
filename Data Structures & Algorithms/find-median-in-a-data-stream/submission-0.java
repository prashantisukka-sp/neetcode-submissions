class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue(Collections.reverseOrder());
        minHeap = new PriorityQueue();
    }
    
    public void addNum(int num) {
        if (minHeap.peek() == null || num >= minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        double median = 0.0;
        if (maxHeap.size() > minHeap.size()) {
            median = (double) maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            median = (double) minHeap.peek();
        } else {
            median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return median;
    }
}
