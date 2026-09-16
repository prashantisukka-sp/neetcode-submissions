class ListNode {
    ListNode prev;
    int val;

    public ListNode(int val) {
        this.val = val;
    }
}
class MyStack {
    ListNode tail;
    int length;

    public MyStack() {        
    }
    
    public void push(int x) {
        ListNode newNode = new ListNode(x);
        newNode.prev = tail;
        tail = newNode;
    }
    
    public int pop() {
        int val = tail.val;
        tail = tail.prev;
        return val;
    }
    
    public int top() {
        return tail.val;
    }
    
    public boolean empty() {
        return tail == null;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */