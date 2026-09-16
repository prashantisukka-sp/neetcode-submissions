class SegmentTree {
   int l;
   int r; 
   SegmentTree left;
   SegmentTree right;

   SegmentTree(int l, int r) {
       this.l = l;
       this.r = r;
       this.left = null;
       this.right = null;
   }
}

class MyCalendar {
    SegmentTree root;

    public MyCalendar() {
        root = null;
    }

    boolean insert(SegmentTree node, int startTime, int endTime) {
        if (endTime <= node.l) {
            if (node.left == null) {
                node.left = new SegmentTree(startTime, endTime);
                return true;
            }
            return insert(node.left, startTime, endTime);
        }
        if (startTime >= node.r) {
            if (node.right == null) {
                node.right = new SegmentTree(startTime, endTime);
                return true;
            }
            return insert(node.right, startTime, endTime);
        }
        return false;
    }
    
    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new SegmentTree(startTime, endTime);
            return true;
        }
        return insert(root, startTime, endTime);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */