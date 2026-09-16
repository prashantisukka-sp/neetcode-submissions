class MinStack {
    Stack<Integer> st = new Stack();
    Stack<Integer> min = new Stack();

    public MinStack() {
        
    }
    
    public void push(int val) {
        st.push(val);
        if (min.isEmpty() || min.peek() >= val) {
            min.push(val);
        }
    }
    
    public void pop() {
        if (!st.isEmpty()) {
            int top = st.pop();
            if (top == min.peek()) {
                min.pop();
            }
        }
    }
    
    public int top() {
        if (!st.isEmpty()) return st.peek();
        return -1;
    }
    
    public int getMin() {
        if (!min.isEmpty()) return min.peek();
        return -1;
    }
}
