class MyStack {
     Queue<Integer> queue;
     Queue<Integer> queue1;

    public MyStack() {
         queue=new LinkedList<>();
         queue1=new LinkedList<>();
    }
    
    public void push(int x) {
      if(queue.isEmpty()){
            queue.add(x);
        }else {
            while (!queue.isEmpty()){
                queue1.add(queue.poll());
            }
            queue.add(x);
            while (!queue1.isEmpty()){
                queue.add(queue1.poll());
            }
        }   
    }
    
    public int pop() {
        return  queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
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