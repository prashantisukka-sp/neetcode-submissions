class ListNode {
    ListNode prev;
    ListNode next;
    int val;

    public ListNode(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class MyLinkedList {
    ListNode head;
    ListNode tail;
    int length;

    public MyLinkedList() {
        
    }
    
    public int get(int index) {
        if (index >= length || index < 0) {
            return -1;
        }
        ListNode temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            newNode.next.prev = newNode;
            head = newNode;
        }
        length++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            newNode.prev.next = newNode;
            tail = newNode;
        }
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > length) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
        } else if (index == length) {
            addAtTail(val);
        } else {
            ListNode newNode = new ListNode(val);
            ListNode temp = head;
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
            newNode.prev = temp.prev;
            newNode.next = temp;
            temp.prev = newNode;
            newNode.prev.next = newNode;
            length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if (length == 0 || index >= length || index < 0) {
            return;
        } 
        if (index == 0) {
            head = head.next;
            if (length > 1) head.prev = null;
        } else if (index == length - 1) {
            tail = tail.prev;
            if (length > 1) tail.next = null;
        } else {
            ListNode temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
        }
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */