class ListNode {
    ListNode next;
    ListNode prev;
    String url;

    public ListNode(String url) {
        this.url = url;
    }
}

class BrowserHistory {
    ListNode curr;

    public BrowserHistory(String homepage) {    
        this.curr = new ListNode(homepage); 
    }
    
    public void visit(String url) {
        ListNode newNode = new ListNode(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = newNode;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps && curr.prev != null; i++) {
            curr = curr.prev;
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps && curr.next != null; i++) {
            curr = curr.next;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */